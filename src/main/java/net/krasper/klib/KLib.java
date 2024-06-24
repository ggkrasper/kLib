package net.krasper.klib;

import net.krasper.klib.command.gamemode.GMAdventure;
import net.krasper.klib.command.gamemode.GMCreative;
import net.krasper.klib.command.gamemode.GMSpectator;
import net.krasper.klib.command.gamemode.GMSurvival;
import net.krasper.klib.msg.MessageFile;
import net.krasper.klib.msg.MessageManager;
import net.krasper.klib.util.SmallFont;
import org.bukkit.plugin.java.JavaPlugin;

public final class KLib extends JavaPlugin {

    private MessageFile messageFile;
    private MessageManager messageManager;
    private SmallFont smallFont;

    @Override
    public void onEnable() {

        messageFile = new MessageFile(this);
        messageManager = new MessageManager(this);
        smallFont = new SmallFont(this);

        new GMAdventure(this);
        new GMCreative(this);
        new GMSpectator(this);
        new GMSurvival(this);
    }

    @Override
    public void onDisable() {
    }

    public MessageFile getMessageFile() {
        return messageFile;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }

    public SmallFont getSmallFont() {
        return smallFont;
    }
}
