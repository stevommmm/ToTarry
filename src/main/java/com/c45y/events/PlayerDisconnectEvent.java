package com.c45y.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Fire an event to let other plugins know if want to handle the real user
 * logout
 *
 * @author c45y
 */
public class PlayerDisconnectEvent extends PlayerQuitEvent {

    private static final HandlerList handlers = new HandlerList();
    private long logoutTime;

    public PlayerDisconnectEvent(final Player who, final String quitMessage) {
        super(who, quitMessage);
        this.logoutTime = System.currentTimeMillis();
    }

    /**
     * Gets the timestamp the player logged out
     *
     * @return long logout time
     */
    public long getLogoutTime() {
        return this.logoutTime;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
