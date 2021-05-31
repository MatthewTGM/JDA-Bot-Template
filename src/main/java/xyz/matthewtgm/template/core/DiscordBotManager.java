package xyz.matthewtgm.template.core;

import lombok.Getter;
import xyz.matthewtgm.template.commands.CommandManager;
import xyz.matthewtgm.template.config.ConfigManager;
import xyz.matthewtgm.template.files.FileManager;

public class DiscordBotManager {

    @Getter private final FileManager fileManager = new FileManager();
    @Getter private final CommandManager commandManager = new CommandManager();
    @Getter private final ConfigManager configManager = new ConfigManager();

}