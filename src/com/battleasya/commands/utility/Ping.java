package com.battleasya.commands.utility;

import de.myzelyam.api.vanish.VanishAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
// Deprecated: import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ping implements CommandExecutor {

    private static Method getHandleMethod;
    private static Field pingField;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        try {

            if (args.length == 0) {
                Player p = Bukkit.getPlayer(sender.getName());
                // Deprecated: int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * 0.8);
                int ping = (int) (getPing(p) * 0.8);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Your ping is &c" + ping + " &6ms."));
                return true;
            }

            if (args.length == 1) {
                Player p = Bukkit.getPlayer(args[0]);
                if (p != null && !VanishAPI.isInvisible(p)) {
                    // Deprecated: int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * 0.8);
                    int ping = (int) (getPing(p) * 0.8);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c" + p.getName() + "&6's ping is &c" + ping + " &6ms."));
                    return true;
                }
            }

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSyntax: /ping [name]"));
            return true;

        } catch (Exception e) {
            return true;
        }

    }

    /* https://www.spigotmc.org/threads/get-player-ping-with-reflection.147773/ */
    /* credits to konsolas for the lazily loaded system */
    public int getPing(Player p) {

        try {

            if (getHandleMethod == null) {
                getHandleMethod = p.getClass().getDeclaredMethod("getHandle");
                getHandleMethod.setAccessible(true);
            }

            Object entityPlayer = getHandleMethod.invoke(p);

            if (pingField == null) {
                pingField = entityPlayer.getClass().getDeclaredField("ping");
                pingField.setAccessible(true);
            }

            return pingField.getInt(entityPlayer);

        } catch (Exception e) {
            return 0;
        }
    }

}
