package ga.matthewtgm.template;

import ga.matthewtgm.json.files.JsonWriter;
import ga.matthewtgm.json.objects.JsonObject;
import ga.matthewtgm.template.commands.CommandManager;
import ga.matthewtgm.template.config.ConfigManager;
import ga.matthewtgm.template.files.FileManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DiscordBot {

    private static DiscordBot INSTANCE;
    private final FileManager fileManager = new FileManager();
    private final ConfigManager configManager = new ConfigManager();
    private final CommandManager commandManager = new CommandManager();

    private String token;
    private JDA jda;

    public static DiscordBot getInstance() {
        if (INSTANCE == null)
            INSTANCE = new DiscordBot();
        return INSTANCE;
    }

    public void start() throws Exception {
        this.getFileManager().init();
        this.getConfigManager().init();
        this.getCommandManager().init();
        if (token == null) {
            this.getConfigManager().getConfigObj().putIfAbsent("token", "");
            this.token = (String) this.getConfigManager().getConfigObj().getOrDefault("token", "");
            this.getConfigManager().save();
        }
        jda = JDABuilder.createDefault(token).build();
        jda.addEventListener(this.getCommandManager());
        jda.awaitReady();
    }

    public JDA getJda() {
        return jda;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

}