package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class PlayerMessageEvent extends BaseEvent implements Cancellable {

    private final Player player;
    private @Nullable UUID targetUniqueId;
    private @Nullable Player target;
    private @Nullable String targetName;
    private boolean isCancellable;

    /**
     * Constructs a PlayerMessageEvent for a local message sent on the same server.
     *
     * @param player The player who sent the message.
     * @param target The target player who received the message, or null if not applicable.
     */
    public PlayerMessageEvent(Player player, @Nullable Player target) {
        this.player = player;
        this.target = target;
    }

    /**
     * Constructs a PlayerMessageEvent for a message sent cross-network to a different server.
     *
     * @param player         The player who sent the message.
     * @param targetUniqueId The UUID of the target player, or null if not applicable.
     * @param targetName     The name of the target player, or null if not available.
     */
    public PlayerMessageEvent(Player player, @Nullable UUID targetUniqueId, @Nullable String targetName) {
        this.player = player;
        this.targetUniqueId = targetUniqueId;
        this.targetName = targetName;
    }

    /**
     * Gets the player who sent the message.
     *
     * @return The player who sent the message.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the target player who received the message, if available (local only).
     *
     * @return The target player, or null if not available or cross-network.
     */
    public @Nullable Player getTarget() {
        return target;
    }

    /**
     * Gets the name of the target player, if available (cross-network only).
     *
     * @return The target player's name, or null if not available or local.
     */
    public @Nullable String getTargetName() {
        return targetName;
    }

    /**
     * Gets the UUID of the target player, if available (cross-network only).
     *
     * @return The target player's UUID, or null if not available or local.
     */
    public @Nullable UUID getTargetUniqueId() {
        return targetUniqueId;
    }

    /**
     * Returns true if this event represents a local message (same server).
     *
     * @return true if local (target is non-null), false otherwise.
     */
    public boolean isLocal() {
        return target != null;
    }

    /**
     * Returns true if this event represents a cross-network message (different server).
     *
     * @return true if cross-network (targetUniqueId is non-null), false otherwise.
     */
    public boolean isCrossNetwork() {
        return targetUniqueId != null;
    }

    @Override
    public boolean isCancelled() {
        return isCancellable;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancellable = b;
    }
}
