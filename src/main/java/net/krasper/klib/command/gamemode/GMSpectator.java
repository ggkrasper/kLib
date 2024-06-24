package net.krasper.klib.command.gamemode;

import net.krasper.klib.KLib;
import net.krasper.klib.command.cmd.CMD;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GMSpectator extends CMD {

    private KLib core;

    public GMSpectator(KLib core) {
        super("gmsp", new String[]{"spectator"}, "klib.command.spectator");
        this.core = core;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if(Bukkit.getPlayerExact(args[0]) != null) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target != null) {
                        target.setGameMode(GameMode.SPECTATOR);
                        String targetMSG = core.getMessageManager().getMessage("gamemode.change-target");
                        targetMSG = targetMSG.replaceAll("<executer>", player.getName());
                        targetMSG = targetMSG.replaceAll("<gamemode>", GameMode.SPECTATOR.name());
                        target.sendMessage(targetMSG);
                        String playerMSG = core.getMessageManager().getMessage("gamemode.change-executer-other");
                        playerMSG = playerMSG.replaceAll("<target>", target.getName());
                        playerMSG = playerMSG.replaceAll("<gamemode>", GameMode.SPECTATOR.name());
                        player.sendMessage(playerMSG);
                    } else {
                        player.sendMessage(core.getMessageManager().getMessage("target-offline"));
                    }
                } else {
                    player.sendMessage(core.getMessageManager().getMessage("target-offline"));
                }
            } else if(args.length == 0) {
                player.setGameMode(GameMode.SPECTATOR);
                String msg = core.getMessageManager().getMessage("gamemode.change-executer-self");
                msg = msg.replaceAll("<gamemode>", GameMode.SPECTATOR.name());
                player.sendMessage(msg);
            } else {
                player.sendMessage(core.getMessageManager().getMessage("invalid-usage"));
            }

        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
