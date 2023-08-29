package com.battleasya.Hdlr;

import com.battleasya.BAUtility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class StaffChat implements Listener {

    private final BAUtility plugin;

    public StaffChat(BAUtility plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String playerName = event.getPlayer().getName();
        if (plugin.chatToggleList.containsKey(playerName)) {
            event.setCancelled(true);
            plugin.msgStaff("&8[&4Staff Chat&8] &f&l" + playerName + "&8: &e" + event.getMessage());
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        String playerName = event.getPlayer().getName();
        plugin.staffList.remove(playerName);
        plugin.chatToggleList.remove(playerName);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player.hasPermission("staff.chat")) {
            plugin.staffList.put(player.getName(), 1);
        }
    }

}
