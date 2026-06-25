package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
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
    private boolean luckPermsOverridden;
    private ChatType chatType;
    private @Nullable String channel;
    private final List<Component> leadingPrefixes = new ArrayList<>();
    private final List<Component> trailingSuffixes = new ArrayList<>();

    public PlayerChatEvent(Player player, Component prefix, Component suffix, Component message, String permission) {
        this.player = player;
        this.prefix = prefix;
        this.suffix = suffix;
        this.luckPermsOverridden = false;
        this.message = message;
        this.permission = permission;
        this.playerColor = NamedTextColor.GRAY.asHexString();
        this.messageColor = NamedTextColor.GRAY.asHexString();
        this.viewers = null;
        this.chatType = ChatType.PUBLIC;
        this.channel = null;
    }

    public PlayerChatEvent(Player player, Component prefix, Component suffix, Component message) {
        this.player = player;
        this.prefix = prefix;
        this.suffix = suffix;
        this.message = message;
        this.permission = null;
        this.luckPermsOverridden = false;
        this.playerColor = NamedTextColor.GRAY.asHexString();
        this.messageColor = NamedTextColor.GRAY.asHexString();
        this.viewers = null;
        this.chatType = ChatType.PUBLIC;
        this.channel = null;
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
        this.luckPermsOverridden = false;
        this.chatType = ChatType.PUBLIC;
        this.channel = null;
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
        this.luckPermsOverridden = false;
        this.chatType = ChatType.PUBLIC;
        this.channel = null;
    }

    public void messageColor(String messageColor) {
        this.messageColor = messageColor;
        this.luckPermsOverridden = true;
    }

    public String messageColor() {
        return this.messageColor;
    }

    public void playerColor(String playerColor) {
        this.playerColor = playerColor;
        this.luckPermsOverridden = true;
    }

    public String playerColor() {
        return this.playerColor;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
        this.luckPermsOverridden = true;
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
        this.luckPermsOverridden = true;
    }

    public void suffix(Component component) {
        this.suffix = component;
        this.luckPermsOverridden = true;
    }

    public void message(Component component) {
        this.message = component;
        this.luckPermsOverridden = true;
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
     * Has another plugin overridden the chat formatting, so LuckPerms
     * prefix/suffix/colors should not be applied?
     *
     * @return true if the formatting was overridden by another plugin.
     */
    public boolean isLuckPermsOverridden() {
        return luckPermsOverridden;
    }

    public void setLuckPermsOverridden(boolean overridden) {
        luckPermsOverridden = overridden;
    }

    /**
     * @deprecated renamed to {@link #isLuckPermsOverridden()}. Will be removed in a future release.
     */
    @Deprecated(forRemoval = true)
    public boolean isModified() {
        return isLuckPermsOverridden();
    }

    /**
     * @deprecated renamed to {@link #setLuckPermsOverridden(boolean)}. Will be removed in a future release.
     */
    @Deprecated(forRemoval = true)
    public void setModified(boolean modified) {
        setLuckPermsOverridden(modified);
    }

    public @Nullable List<UUID> getViewers() {
        return viewers;
    }

    public void setViewers(@Nullable List<UUID> viewers) {
        this.viewers = viewers;
        this.luckPermsOverridden = true;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
        this.luckPermsOverridden = true;
    }

    public @Nullable String getChannel() {
        return channel;
    }

    public void setChannel(@Nullable String channel) {
        this.channel = channel;
        this.luckPermsOverridden = true;
    }

    /**
     * Adds a component that will be rendered <b>before</b> the LuckPerms prefix
     * (left of the prefix). Multiple additions render in the order they were added.
     * <p>
     * Unlike {@link #prefix(Component)}, this does not flag the event as
     * LuckPerms-overridden, so Bookshelf still applies the LuckPerms prefix.
     *
     * @param component the leading component to render before the prefix.
     */
    public void addLeadingPrefix(Component component) {
        this.leadingPrefixes.add(component);
    }

    public List<Component> getLeadingPrefixes() {
        return leadingPrefixes;
    }

    /**
     * Adds a component that will be rendered <b>after</b> the LuckPerms suffix
     * (right of the suffix). Multiple additions render in the order they were added.
     * <p>
     * Unlike {@link #suffix(Component)}, this does not flag the event as
     * LuckPerms-overridden, so Bookshelf still applies the LuckPerms suffix.
     *
     * @param component the trailing component to render after the suffix.
     */
    public void addTrailingSuffix(Component component) {
        this.trailingSuffixes.add(component);
    }

    public List<Component> getTrailingSuffixes() {
        return trailingSuffixes;
    }
}