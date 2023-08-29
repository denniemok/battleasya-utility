package com.battleasya.Cmd.Broadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ABC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("staffbc.use")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Unknown Command."));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSyntax: /abc <message>"));
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&4BattleHawk &8// &c" + str));
        return true;

    }

}
