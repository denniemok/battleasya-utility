package com.battleasya.Cmd.Broadcast;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tbc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("staffbc.use")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Unknown Command."));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSyntax: /tbc <message>"));
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        Player p = (Player) sender;
        p.chat("/tm bc &f\\n&f" + str);
        return true;

    }

}
