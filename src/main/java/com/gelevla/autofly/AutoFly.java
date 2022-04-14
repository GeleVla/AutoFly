package com.gelevla.autofly;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class AutoFly extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        new File(this.getDataFolder(), "config.yml");
        String permission = this.getConfig().getString("permission");
        String message = this.getConfig().getString("message");
        boolean byDefault = this.getConfig().getBoolean("byDefault");
        this.getServer().getPluginManager().registerEvents(new Listeners(permission, message, byDefault), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
