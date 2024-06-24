package net.krasper.klib.command.gamemode;

import net.krasper.klib.KLib;
import net.krasper.klib.command.cmd.CMD;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GMCreative extends CMD {

    private KLib core;

    public GMCreative(KLib core) {
        super("gmc", new String[]{"creative"}, "klib.command.creative");
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
                        target.setGameMode(GameMode.CREATIVE);
                        String targetMSG = core.getMessageManager().getMessage("gamemode.change-target");
                        targetMSG = targetMSG.replaceAll("<executer>", player.getName());
                        targetMSG = targetMSG.replaceAll("<gamemode>", GameMode.CREATIVE.name());
                        target.sendMessage(targetMSG);
                        String playerMSG = core.getMessageManager().getMessage("gamemode.change-executer-other");
                        playerMSG = playerMSG.replaceAll("<target>", target.getName());
                        playerMSG = playerMSG.replaceAll("<gamemode>", GameMode.CREATIVE.name());
                        player.sendMessage(playerMSG);
                    } else {
                        player.sendMessage(core.getMessageManager().getMessage("target-offline"));
                    }
                } else {
                    player.sendMessage(core.getMessageManager().getMessage("target-offline"));
                }
            } else if(args.length == 0) {
                player.setGameMode(GameMode.CREATIVE);
                String msg = core.getMessageManager().getMessage("gamemode.change-executer-self");
                msg = msg.replaceAll("<gamemode>", GameMode.CREATIVE.name());
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
