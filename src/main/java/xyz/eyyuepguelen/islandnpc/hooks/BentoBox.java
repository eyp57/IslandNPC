package xyz.eyyuepguelen.islandnpc.hooks;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import world.bentobox.bentobox.api.events.island.IslandCreateEvent;
import world.bentobox.bentobox.api.events.island.IslandDeleteEvent;
import xyz.eyyuepguelen.islandnpc.IslandNPC;

import java.util.UUID;

public class BentoBox implements Listener {
    @EventHandler
    public void IslandNewEvent(IslandCreateEvent e) {
        Location location = e.getLocation();
        IslandNPC.getInstance().createIslandNPC(e.getPlayerUUID(), location);
    }
    @EventHandler
    public void IslandDeleteEvent(IslandDeleteEvent e) {
        UUID player = e.getPlayerUUID();
        IslandNPC.getInstance().deleteIslandNPC(player);
    }
}
