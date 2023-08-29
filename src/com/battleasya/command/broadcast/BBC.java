package com.battleasya.command.broadcast;

import com.battleasya.handler.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BBC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("staffbc.use")) {
            Util.msgPlayer(sender, "&8(&4&l!&8) &6Unknown Command.");
            return true;
        }

        if (args.length == 0) {
            Util.msgPlayer(sender, "&cSyntax: /bbc <message>");
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        Util.broadcast("");
        Util.broadcast("");
        Util.broadcast("&7&m---»--*-------------------------------------*--«---");
        Util.broadcast("");
        Util.broadcast("&c" + str);
        Util.broadcast("");
        Util.broadcast("&7&m---»--*-------------------------------------*--«---");
        Util.broadcast("");
        Util.broadcast("");
        return true;

    }

}
