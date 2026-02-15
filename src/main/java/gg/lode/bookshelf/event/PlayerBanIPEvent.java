package gg.lode.bookshelf.event;

import org.bukkit.command.CommandSender;

public class PlayerBanIPEvent extends PlayerInfractionEvent {

    private final String ip;
    private long duration;

    public PlayerBanIPEvent(CommandSender issuer, String ip, String reason, long duration) {
        super(issuer, reason);
        this.ip = ip;
        this.duration = duration;
    }

    public String getIp() {
        return ip;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
