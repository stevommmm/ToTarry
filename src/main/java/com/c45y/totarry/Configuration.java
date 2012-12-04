/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c45y.totarry;

/**
 *
 * @author c45y
 */
public class Configuration {

    private final ToTarry plugin;
    public boolean BROADCAST_DISCONNECT;
    public boolean FIRE_EVENT;
    public boolean IGNORE_MODS;

    public Configuration(ToTarry instance) {
        plugin = instance;
    }

    public void save() {
        plugin.saveConfig();
    }

    public void load() {
        plugin.reloadConfig();

        BROADCAST_DISCONNECT = plugin.getConfig().getBoolean("disconnect.broadcast", false);
        FIRE_EVENT = plugin.getConfig().getBoolean("disconnect.fire-event", true);
        IGNORE_MODS = plugin.getConfig().getBoolean("disconnect.ignore-mods", true);

    }
}
