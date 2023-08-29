package com.battleasya.handler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PexBlock implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {

        Player p = event.getPlayer();
        String msg = event.getMessage();

        if (msg.startsWith("/pex") || msg.startsWith("/permissionsex")) {
            event.setCancelled(true);
            Util.msgPlayer(p, "&8(&4&l!&8) &6Unknown Command.");
        }

    }

}
