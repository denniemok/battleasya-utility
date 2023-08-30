package com.battleasya.command.staffchat;

import com.battleasya.BAUtility;
import com.battleasya.handler.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCT implements CommandExecutor {

    private final BAUtility plugin;

    public SCT(BAUtility plugin) {
        this.plugin = plugin;
    }

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
            if (plugin.chatToggleList.containsKey(sender.getName())) {
                plugin.chatToggleList.remove(sender.getName());
                Util.msgPlayer(sender, "&8[&4Staff Chat&8] &cChat Mode Disabled.");
            } else {
                plugin.chatToggleList.put(sender.getName(), 1);
                Util.msgPlayer(sender, "&8[&4Staff Chat&8] &aChat Mode Enabled.");
            }
            return true;
        }

        Util.msgPlayer(sender, "&cSyntax: /sct");
        return true;

    }

}
