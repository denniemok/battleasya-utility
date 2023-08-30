package com.battleasya.bautility.command.staffchat;

import com.battleasya.bautility.handler.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCT implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        if(!sender.hasPermission("staffchat.use")) {
            Util.msgPlayer(sender, "&8(&4&l!&8) &6Unknown Command.");
            return true;
        }

        if (args.length == 0) {
            if (Util.chatToggleList.containsKey(sender.getName())) {
                Util.chatToggleList.remove(sender.getName());
                Util.msgPlayer(sender, "&8[&4Staff Chat&8] &cChat Mode Disabled.");
            } else {
                Util.chatToggleList.put(sender.getName(), 1);
                Util.msgPlayer(sender, "&8[&4Staff Chat&8] &aChat Mode Enabled.");
            }
            return true;
        }

        Util.msgPlayer(sender, "&cSyntax: /sct");
        return true;

    }

}
