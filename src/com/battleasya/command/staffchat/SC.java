package com.battleasya.command.staffchat;

import com.battleasya.handler.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        if(!sender.hasPermission("staffchat.use")) {
            Util.msgPlayer(sender, "&8(&4&l!&8) &6Unknown Command.");
            return true;
        }

        if (args.length == 0) {
            Util.msgPlayer(sender, "&cSyntax: /sc <message>");
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        Util.msgStaff("&8[&4Staff Chat&8] &f&l" + sender.getName() + "&8: &e" + str);
        return true;

    }

}
