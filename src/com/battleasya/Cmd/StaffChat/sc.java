package com.battleasya.Cmd.StaffChat;

import com.battleasya.BAUtility;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class sc implements CommandExecutor {

    private final BAUtility plugin;

    public sc(BAUtility plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("staff.chat")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Unknown Command."));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4Staff Chat&8] &c/sc <message>"));
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        plugin.msgStaff("&8[&4Staff Chat&8] &f&l" + sender.getName() + "&8: &e" + str);
        return true;

    }

}
