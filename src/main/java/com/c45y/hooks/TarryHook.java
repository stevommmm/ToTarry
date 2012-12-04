/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c45y.hooks;

import com.c45y.totarry.ToTarry;
import net.minecraft.server.NetServerHandler;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.CraftServer;

/**
 *
 * @author c45y
 */
public class TarryHook extends NetServerHandler {

    private final NetServerHandler nsh;
    private final ToTarry plugin;

    public TarryHook(ToTarry plugin, NetServerHandler nsh) {
        super(((CraftServer) Bukkit.getServer()).getServer(), nsh.networkManager, nsh.player);
        this.nsh = nsh;
        this.plugin = plugin;
    }

    @Override
    public void a(String s, Object[] aobject) {
        if (!this.plugin.logout.containsKey(this.player.name)) {
            this.plugin.logout.put(this.player.name, System.currentTimeMillis());
        } else {
            Long logoutTime = this.plugin.logout.get(this.player.name);
            if ((System.currentTimeMillis() - 10000) > logoutTime) {
                this.plugin.logout.remove(this.player.name);
                this.nsh.a(s, aobject);
            }
        }
    }
}