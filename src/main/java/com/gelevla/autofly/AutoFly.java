package com.gelevla.autofly;

import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

import java.io.File;

public final class AutoFly extends JavaPlugin {

    public AutoFly() {
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        new File(this.getDataFolder(), "config.yml");
        String permission = this.getConfig().getString("permission");
        String message = this.getConfig().getString("message");
        boolean joinFly = this.getConfig().getBoolean("joininflymode");
        this.getServer().getPluginManager().registerEvents(new Listeners(permission, message, joinFly), this);

        int pluginId = 14925; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
