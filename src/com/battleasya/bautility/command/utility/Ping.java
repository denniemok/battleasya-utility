package com.battleasya.bautility.command.utility;

import com.battleasya.bautility.handler.Util;
import de.myzelyam.api.vanish.VanishAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        try {

            if (args.length == 0) {
                Player p = Bukkit.getPlayer(sender.getName());
                int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * 0.8);
                Util.msgPlayer(sender, "&6Your ping is &c" + ping + " &6ms.");
                return true;
            }

            if (args.length == 1) {
                Player p = Bukkit.getPlayer(args[0]);
                if (p != null && !VanishAPI.isInvisible(p)) {
                    int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * 0.8);
                    Util.msgPlayer(sender, "&c" + p.getName() + "&6's ping is &c" + ping + " &6ms.");
                } else {
                    Util.msgPlayer(sender, "&cError: &4You cannot ping that person.");
                }
                return true;
            }

            Util.msgPlayer(sender, "&cSyntax: /ping [name]");
            return true;

        } catch (Exception e) {
            return true;
        }

    }

}
