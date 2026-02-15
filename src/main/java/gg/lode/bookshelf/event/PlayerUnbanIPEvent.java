package gg.lode.bookshelf.event;

import org.bukkit.command.CommandSender;

public class PlayerUnbanIPEvent extends PlayerInfractionEvent {

    private final String ip;

    public PlayerUnbanIPEvent(CommandSender issuer, String ip, String reason) {
        super(issuer, reason);
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }
}
