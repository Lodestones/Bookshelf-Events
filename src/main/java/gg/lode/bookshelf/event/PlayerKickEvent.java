package gg.lode.bookshelf.event;

import org.bukkit.command.CommandSender;

import java.util.UUID;

public class PlayerKickEvent extends PlayerInfractionEvent {

    private final UUID targetUUID;
    private final String targetName;

    public PlayerKickEvent(CommandSender issuer, UUID targetUUID, String targetName, String reason) {
        super(issuer, reason);
        this.targetUUID = targetUUID;
        this.targetName = targetName;
    }

    public UUID getTargetUUID() {
        return targetUUID;
    }

    public String getTargetName() {
        return targetName;
    }
}
