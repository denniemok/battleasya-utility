package com.battleasya.command.staffchat;

import com.battleasya.BAUtility;
import org.bukkit.ChatColor;
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
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Unknown Command."));
            return true;
        }

        if (args.length == 0) {
            if (plugin.chatToggleList.containsKey(sender.getName())) {
                plugin.chatToggleList.remove(sender.getName());
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4Staff Chat&8] &cToggle Disabled."));
            } else {
                plugin.chatToggleList.put(sender.getName(), 1);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4Staff Chat&8] &aToggle Enabled."));
            }
            return true;
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSyntax: /sct"));
        return true;

    }

}
