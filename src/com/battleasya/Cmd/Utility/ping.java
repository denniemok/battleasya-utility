package com.battleasya.Cmd.Utility;

import de.myzelyam.api.vanish.VanishAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        try {

            if (args.length == 0) {
                Player p = (Player) sender;
                int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * 0.8);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Your ping is &c" + ping + " &6ms."));
                return true;
            }

            if (args.length == 1) {
                Player a = Bukkit.getPlayer(args[0]);
                if (a != null && !VanishAPI.isInvisible(a)) {
                    int ping = (int) (((((CraftPlayer) a).getHandle()).ping) * 0.8);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c" + args[0] + "&6's ping is &c" + ping + " &6ms."));
                    return true;
                }
            }

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Syntax: /ping"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Syntax: /ping <name>"));
            return true;

        } catch (Exception e) {
            return true;
        }

    }

}
