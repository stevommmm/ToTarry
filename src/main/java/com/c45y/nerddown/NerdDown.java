package com.c45y.nerddown;

import com.c45y.hooks.NetServerHandlerHook;
import java.util.HashMap;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NerdDown extends JavaPlugin implements Listener {

    public HashMap<String, Long> logout = new HashMap<String, Long>();


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
	}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
         new NetServerHandlerHook(this, ((CraftPlayer)event.getPlayer()).getHandle().netServerHandler);
    }
}
