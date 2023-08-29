package com.battleasya.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class StaffChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String playerName = event.getPlayer().getName();
        if (Util.chatToggleList.containsKey(playerName)) {
            event.setCancelled(true);
            Util.msgStaff("&8[&4Staff Chat&8] &f&l" + playerName + "&8: &e" + event.getMessage());
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        String playerName = event.getPlayer().getName();
        Util.staffList.remove(playerName);
        Util.chatToggleList.remove(playerName);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player.hasPermission("staffchat.use")) {
            Util.staffList.put(player.getName(), 1);
        }
    }

}
