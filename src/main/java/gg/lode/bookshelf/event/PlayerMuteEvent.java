package gg.lode.bookshelf.event;

import org.bukkit.command.CommandSender;

import java.util.UUID;

public class PlayerMuteEvent extends PlayerInfractionEvent {

    private final UUID targetUUID;
    private final String targetName;
    private long duration;

    public PlayerMuteEvent(CommandSender issuer, UUID targetUUID, String targetName, String reason, long duration) {
        super(issuer, reason);
        this.targetUUID = targetUUID;
        this.targetName = targetName;
        this.duration = duration;
    }

    public UUID getTargetUUID() {
        return targetUUID;
    }

    public String getTargetName() {
        return targetName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
