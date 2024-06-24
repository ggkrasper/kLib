package net.krasper.klib.msg;

import net.krasper.klib.KLib;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class MessageManager {

    private static KLib core;
    private FileConfiguration config;

    public MessageManager(KLib core) {
        MessageManager.core = core;
        setup(core);
    }

    private void setup(KLib core) {
        config = core.getMessageFile().getFileConfiguration();
        if (config == null) {
            core.getLogger().severe("MessageFile configuration is null. Please check if the configuration file is loaded correctly.");
        }
    }

    public String getMessageNonFormat(String key) {
        if(config.getString(key) != null) {
            return config.getString(key);
        } else {
            return ChatColor.translateAlternateColorCodes('&', getMessage("invalid-msg"));
        }
    }

    public String getMessage(String key) {
        if(config.getString(key) != null) {
            return ChatColor.translateAlternateColorCodes('&', config.getString(key));
        } else {
            return ChatColor.translateAlternateColorCodes('&', getMessage("invalid-msg"));
        }
    }

    public static Object get(String key) {
        return core.getMessageFile().getFileConfiguration().get(key);
    }

    public static String MSG_NO_PERMISSION() {
        return get("no-permission").toString();
    }

}
