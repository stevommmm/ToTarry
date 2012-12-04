    Tarry   - verb

    To delay or be tardy in acting, starting, coming, etc.; linger or loiter. 

This plugin attempts to do just that, make the player linger in game as a *ghost* even after a disconnect.

Currently accomplished by hooking the network handler and overriding the specific method (*that will no doubt change as bukkit updates*) to apply some of our own logic to log-outs

At the time of writing this we seem immune to ever so frequent exploits suffered by many plugins attempting to accomplish this functionality.

**Problems**:

- Can only deal a max 3 hearts damage to *logged out* entities

**Concerns**:

- Lag and network slowdowns due to our messing with the NetServerHandler