package com.battleasya.Cmd.Broadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class bbc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("staffbc.use")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Unknown Command."));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSyntax: /bbc <message>"));
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7&m---»--*-------------------------------------*--«---"));
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&c" + str));
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7&m---»--*-------------------------------------*--«---"));
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("");
        return true;

    }

}
