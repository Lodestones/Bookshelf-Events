package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Event called when a player respawns.
 * This event allows for customization of the respawn location and behavior.
 *
 * @author John Aquino
 */
public class PlayerRespawnEvent extends BaseEvent {
    private final Player player;
    private Location location;
    private boolean cancelled;

    public PlayerRespawnEvent(@NotNull Player player, @NotNull Location location) {
        super(true);
        this.player = player;
        this.location = location;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public Location getLocation() {
        return location;
    }

    public void setLocation(@NotNull Location location) {
        this.location = location;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
} 