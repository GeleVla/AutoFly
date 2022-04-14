package com.gelevla.autofly;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Listeners implements Listener{
    private String permission;
    private String message;
    private boolean enabledAutoFly;

    Listeners(String permission, String message, boolean enabledAutoFly) {
        this.permission = permission;
        this.message = message;
        this.enabledAutoFly = enabledAutoFly;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        this.setFly(event.getPlayer());
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        this.setFly(event.getPlayer());
    }

    private void setFly(Player player) {
        if (player.hasPermission(this.permission)) {
            player.setAllowFlight(true);
            if (this.enabledAutoFly) {
                player.setFlying(true);
            }

            if (!this.message.isEmpty()) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.message));
            }
        }

    }
}
