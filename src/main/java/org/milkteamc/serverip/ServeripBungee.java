package org.milkteamc.serverip;

import net.md_5.bungee.api.plugin.Plugin;

public final class ServeripBungee extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new BungeeServerIPCommand(this));
    }

}
