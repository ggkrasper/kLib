package net.krasper.klib.msg;

import net.krasper.klib.KLib;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessageFile {

    private final File file;
    private FileConfiguration fileConfiguration;

    private final KLib core;

    public MessageFile(KLib core) {
        this.core = core;
        String path = "messages.yml";
        File configFile = new File(core.getDataFolder(), path);

        file = configFile;

        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            core.saveResource(path, false);
        }

        // Synchronously load the configuration
        reload();
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    public void reload() {
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public void save() {
        try {
            fileConfiguration.save(file);
            reload();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
