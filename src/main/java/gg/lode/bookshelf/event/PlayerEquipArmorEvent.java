package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlayerEquipArmorEvent extends BaseEvent implements Cancellable {

    private boolean isCancelled = false;
    private final Player player;
    private final EquipmentSlot slot;
    private ItemStack itemStack;

    public PlayerEquipArmorEvent(Player player, ItemStack itemStack, EquipmentSlot slot) {
        this.player = player;
        this.slot = slot;
        this.itemStack = itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Player getPlayer() {
        return player;
    }

    public EquipmentSlot getSlot() {
        return slot;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }
}
