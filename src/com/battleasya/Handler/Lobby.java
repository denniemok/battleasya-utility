package com.battleasya.Handler;

import com.battleasya.BAUtility;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Lobby implements Listener {

    private final BAUtility plugin;

    public Lobby(BAUtility plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        Entity vehicle = player.getVehicle();

        if (vehicle != null) {
            if (vehicle.getPassenger() == player) {
                vehicle.eject();
            }
        }

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        if (event.getAction() != Action.PHYSICAL) {
            return;
        }

        Block block = event.getClickedBlock();

        if (block == null) {
            return;
        }

        if (!block.getType().name().contains("_PLATE")) {
            return;
        }

        Player player = event.getPlayer();

        if (block.getType().name().equalsIgnoreCase("GOLD_PLATE")) {
            (new BukkitRunnable() {
                @Override
                public void run() {
                    player.setVelocity(player.getLocation().getDirection().multiply(2.0D).setY(1.0D));
                }
            }).runTaskLater(plugin, 1L);
        } else {
            (new BukkitRunnable() {
                @Override
                public void run() {
                    player.setVelocity(new Vector(0.0D, 2.0D, 0.0D));
                }
            }).runTaskLater(plugin, 1L);
        }

    }

    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();

        if (player != null && entity != null) {
            if (player.getItemInHand().getType() == Material.CACTUS) {
                if (entity.getPassenger() == null) {
                    entity.setPassenger(player);
                }
            }
        }

    }

}
