package xyz.matthewtgm.template.config;

import lombok.Getter;
import xyz.matthewtgm.template.DiscordBot;
import xyz.matthewtgm.tgmconfig.ConfigEntry;
import xyz.matthewtgm.tgmconfig.TGMConfig;

public class ConfigManager {

    @Getter private TGMConfig config;

    public void init() {
        config = new TGMConfig("config", DiscordBot.getManager().getFileManager().configDir);
        config.addIfAbsent(new ConfigEntry<>("token", ""));
        config.addIfAbsent(new ConfigEntry<>("prefix", "!"));
        save();
    }

    public void save() {
        config.save();
    }

}