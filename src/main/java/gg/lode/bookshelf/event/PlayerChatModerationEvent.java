package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fired when a player's chat message is blocked by a moderation check.
 * <p>
 * Cancelling this event overrides the moderation decision and allows the message through.
 *
 * @author John Aquino
 */
public class PlayerChatModerationEvent extends BaseEvent implements Cancellable {

    private boolean isCancelled = false;
    private final Player player;
    private final Component message;
    private final ModerationType type;
    private final String detail;

    public PlayerChatModerationEvent(@NotNull Player player, @NotNull Component message, @NotNull ModerationType type, @Nullable String detail) {
        this.player = player;
        this.message = message;
        this.type = type;
        this.detail = detail;
    }

    public @NotNull Player getPlayer() {
        return player;
    }

    public @NotNull Component getMessage() {
        return message;
    }

    public @NotNull ModerationType getType() {
        return type;
    }

    public @Nullable String getDetail() {
        return detail;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    public enum ModerationType {
        WARNED,
        MUTED,
        GLOBAL_MUTE,
        BANNED_WORD,
        CHARACTER_SPAM,
        COOLDOWN,
        DUPLICATE_MESSAGE
    }
}
