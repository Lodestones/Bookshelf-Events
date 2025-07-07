package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class PlayerChatEvent extends BaseEvent implements Cancellable {

    private final Player player;
    private Component prefix;
    private Component suffix;
    private Component message;
    private boolean isCancelled;
    private String permission;
    private String playerColor;
    private String messageColor;
    private @Nullable List<UUID> viewers;
    private boolean isModified;

    public PlayerChatEvent(Player player, Component prefix, Component suffix, Component message, String permission) {
        this.player = player;
        this.prefix = prefix;
        this.suffix = suffix;
        this.isModified = false;
        this.message = message;
        this.permission = permission;
        this.playerColor = NamedTextColor.GRAY.asHexString();
        this.messageColor = NamedTextColor.GRAY.asHexString();
        this.viewers = null;
    }

    public PlayerChatEvent(Player player, Component prefix, Component suffix, Component message) {
        this.player = player;
        this.prefix = prefix;
        this.suffix = suffix;
        this.message = message;
        this.permission = null;
        this.isModified = false;
        this.playerColor = NamedTextColor.GRAY.asHexString();
        this.messageColor = NamedTextColor.GRAY.asHexString();
        this.viewers = null;
    }

    public PlayerChatEvent(Player player, Component prefix, Component message) {
        this.player = player;
        this.prefix = prefix;
        this.suffix = Component.empty();
        this.message = message;
        this.permission = null;
        this.playerColor = NamedTextColor.GRAY.asHexString();
        this.messageColor = NamedTextColor.GRAY.asHexString();
        this.viewers = null;
        this.isModified = false;
    }

    public PlayerChatEvent(Player player, Component message) {
        this.player = player;
        this.prefix = Component.empty();
        this.suffix = Component.empty();
        this.message = message;
        this.permission = null;
        this.playerColor = NamedTextColor.GRAY.asHexString();
        this.messageColor = NamedTextColor.GRAY.asHexString();
        this.viewers = null;
        this.isModified = false;
    }

    public void messageColor(String messageColor) {
        this.messageColor = messageColor;
        this.isModified = true;
    }

    public String messageColor() {
        return this.messageColor;
    }

    public void playerColor(String playerColor) {
        this.playerColor = playerColor;
        this.isModified = true;
    }

    public String playerColor() {
        return this.playerColor;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
        this.isModified = true;
    }

    public Player getPlayer() {
        return player;
    }

    public Component prefix() {
        return prefix;
    }

    public Component suffix() {
        return suffix;
    }

    public Component message() {
        return message;
    }

    public void prefix(Component component) {
        this.prefix = component;
        this.isModified = true;
    }

    public void suffix(Component component) {
        this.suffix = component;
        this.isModified = true;
    }

    public void message(Component component) {
        this.message = component;
        this.isModified = true;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    /**
     * Has this event been touched by other plugins?
     *
     * @return true if touched by other plugins.
     */
    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }

    public @Nullable List<UUID> getViewers() {
        return viewers;
    }

    public void setViewers(@Nullable List<UUID> viewers) {
        this.viewers = viewers;
        this.isModified = true;
    }
}