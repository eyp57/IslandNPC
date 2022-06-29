package xyz.eyyuepguelen.islandnpc.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class CreateIslandNPC extends Event implements Cancellable {

    protected final Player player;
    protected final UUID playerUUID;
    protected final Location location;

    public CreateIslandNPC(Player player, Location location) {
        super();
        this.player = player;
        this.playerUUID = player.getUniqueId();
        this.location = location;
    }

    @Override
    public HandlerList getHandlers() {

        return null;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {

    }

    public UUID getOwnerUUID() {
        return playerUUID;
    }
    public Player getOwner() {
        return player;
    }

    public Location getLocation() {
        return location;
    }

}
