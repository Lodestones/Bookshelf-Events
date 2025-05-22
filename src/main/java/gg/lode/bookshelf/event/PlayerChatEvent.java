package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Event called when a player sends a chat message.
 * This event allows for customization of the chat message format and content.
 *
 * @author John Aquino
 */
public class PlayerChatEvent extends BaseEvent {
    private final Player player;
    private Component message;
    private Component prefix;
    private Component suffix;
    private String messageColor;
    private String playerColor;
    private String permission;
    private List<UUID> viewers;
    private boolean cancelled;
    private boolean modified;

    public PlayerChatEvent(@NotNull Player player, @NotNull Component message) {
        super(true);
        this.player = player;
        this.message = message;
        this.viewers = new ArrayList<>();
        this.messageColor = "#FFFFFF";
        this.playerColor = "#FFFFFF";
        this.modified = false;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public Component message() {
        return message;
    }

    public void message(@NotNull Component message) {
        this.message = message;
        this.modified = true;
    }

    @Nullable
    public Component prefix() {
        return prefix;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }

    @NotNull
    public List<UUID> getViewers() {
        return viewers;
    }

    public void prefix(@Nullable Component prefix) {
        this.prefix = prefix;
        this.modified = true;
    }

    @Nullable
    public Component suffix() {
        return suffix;
    }

    public void suffix(@Nullable Component suffix) {
        this.suffix = suffix;
        this.modified = true;
    }

    @NotNull
    public String messageColor() {
        return messageColor;
    }

    public void messageColor(@NotNull String messageColor) {
        this.messageColor = messageColor;
        this.modified = true;
    }

    @NotNull
    public String playerColor() {
        return playerColor;
    }

    public void playerColor(@NotNull String playerColor) {
        this.playerColor = playerColor;
        this.modified = true;
    }

    @Nullable
    public String getPermission() {
        return permission;
    }

    public void setPermission(@Nullable String permission) {
        this.permission = permission;
    }

    public void setViewers(List<UUID> viewers) {
        this.viewers = viewers;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isModified() {
        return modified;
    }
} 