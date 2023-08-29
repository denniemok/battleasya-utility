package com.battleasya.Cmd.Broadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NBC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("staffbc.use")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Unknown Command."));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSyntax: /nbc <message>"));
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&4&l[&a&l" + sender.getName() + "&4&l] &c" + str));
        Bukkit.broadcastMessage("");
        return true;

    }

}
