package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import gg.lode.bookshelfapi.api.item.CustomItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Event called when a player crafts a custom item.
 * This event allows for customization of the crafting process and result.
 *
 * @author John Aquino
 */
public class PlayerCraftCustomItemEvent extends BaseEvent {
    private final Player player;
    private final ItemStack result;
    private boolean cancelled;
    private final CustomItem customItem;

    public PlayerCraftCustomItemEvent(@NotNull Player player, CustomItem customItem, @NotNull ItemStack result) {
        super(true);
        this.customItem = customItem;
        this.player = player;
        this.result = result;
    }

    public CustomItem getCustomItem() {
        return customItem;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public ItemStack getResult() {
        return result;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
} 