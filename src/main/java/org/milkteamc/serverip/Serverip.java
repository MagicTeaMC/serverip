package org.milkteamc.serverip;

import org.bukkit.plugin.java.JavaPlugin;


public final class Serverip extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("serverip").setExecutor(new ServerIPCommand());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}


