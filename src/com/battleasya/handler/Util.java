package com.battleasya.handler;

import com.battleasya.BAUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class Util {

    private final BAUtility plugin;

    public Util(BAUtility plugin) {
        this.plugin = plugin;
    }

    public static void msgPlayer(CommandSender sender, String message){
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public void msgStaff(String message) {
        for (Map.Entry<String, Integer> entry : plugin.staffList.entrySet()) {
            Player player = Bukkit.getPlayer(entry.getKey());
            if (player != null) {
                msgPlayer(player, message);
            } else {
                plugin.staffList.remove(entry.getKey());
                plugin.chatToggleList.remove(entry.getKey());
            }
        }
    }

}