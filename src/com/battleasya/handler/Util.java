package com.battleasya.handler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Util {

    public static HashMap<String, Integer> staffList = new HashMap<>();

    public static HashMap<String, Integer> chatToggleList = new HashMap<>();

    public static HashMap<String, Integer> cooldownList = new HashMap<>();

    public static void msgPlayer(CommandSender sender, String message){
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void msgStaff(String message) {
        for (Map.Entry<String, Integer> entry : staffList.entrySet()) {
            Player player = Bukkit.getPlayer(entry.getKey());
            if (player != null) {
                msgPlayer(player, message);
            } else {
                staffList.remove(entry.getKey());
                chatToggleList.remove(entry.getKey());
            }
        }
    }

}