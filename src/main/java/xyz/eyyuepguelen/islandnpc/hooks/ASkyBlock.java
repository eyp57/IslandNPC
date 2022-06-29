package xyz.eyyuepguelen.islandnpc.hooks;

import com.wasteofplastic.askyblock.events.IslandDeleteEvent;
import com.wasteofplastic.askyblock.events.IslandNewEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.eyyuepguelen.islandnpc.IslandNPC;

import java.util.UUID;

public class ASkyBlock implements Listener {

    @EventHandler
    public void IslandNewEvent(IslandNewEvent e) {
        Player player = e.getPlayer();
        Location location = e.getIslandLocation();
        IslandNPC.getInstance().createIslandNPC(player.getUniqueId(), location);
    }
    @EventHandler
    public void IslandDeleteEvent(IslandDeleteEvent e) {
        UUID player = e.getPlayerUUID();
        IslandNPC.getInstance().deleteIslandNPC(player);
    }
}