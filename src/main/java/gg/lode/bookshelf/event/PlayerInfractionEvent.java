package gg.lode.bookshelf.event;

import gg.lode.bookshelfapi.api.event.BaseEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;

public abstract class PlayerInfractionEvent extends BaseEvent implements Cancellable {

    private final CommandSender issuer;
    private String reason;
    private boolean isCancelled;

    public PlayerInfractionEvent(CommandSender issuer, String reason) {
        this.issuer = issuer;
        this.reason = reason;
    }

    public CommandSender getIssuer() {
        return issuer;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }
}
