package com.c45y.totarry;

import com.c45y.events.PlayerDisconnectEvent;
import com.c45y.hooks.TarryHook;
import java.util.HashMap;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ToTarry extends JavaPlugin implements Listener {

    public HashMap<String, Long> logout = new HashMap<String, Long>();
    public final Configuration config = new Configuration(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        this.config.load();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        new TarryHook(this, ((CraftPlayer) event.getPlayer()).getHandle().netServerHandler);
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent event) {
        if (this.config.BROADCAST_DISCONNECT) {
            getServer().broadcastMessage(event.getQuitMessage()); // Not broadcasted by default as bukkit is not usually delaying logouts
        }
    }
}
