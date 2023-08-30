package com.battleasya.bautility.handler;

import com.battleasya.bautility.BAUtility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.scheduler.BukkitRunnable;

public class Reconnect implements Listener {

    private final BAUtility plugin;

    public Reconnect(BAUtility plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent event) {

        String playerName = event.getName();

        if (cooldown(playerName)) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "Please wait for 10 seconds before joining back!");
        }

    }

    public boolean cooldown(String playerName) {
        if (Util.cooldownList.containsKey(playerName)) {
            return true;
        } else {
            Util.cooldownList.put(playerName, 1);
            (new BukkitRunnable() {
                @Override
                public void run() {
                    Util.cooldownList.remove(playerName);
                }
            }).runTaskLater(plugin, 200L); // in ticks
            return false;
        }
    }

}
