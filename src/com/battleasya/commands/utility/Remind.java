package com.battleasya.commands.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Remind implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("litebans.warn")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Unknown Command."));
            return true;
        }

        if (args.length > 1) {
            Player p = Bukkit.getPlayer(args[0]);
            if (p != null) {
                StringBuilder str = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    str.append(args[i]).append(" ");
                }
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&c" + p.getName() + " &7has been reminded for &f" + str + "&7."));
                return true;
            }
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSyntax: /remind <name> <message>"));
        return true;

    }

}
