package xyz.matthewtgm.template;

import lombok.Getter;
import xyz.matthewtgm.template.core.DiscordBotManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DiscordBot {

    private static DiscordBot INSTANCE;
    @Getter private static final DiscordBotManager manager = new DiscordBotManager();

    @Getter private JDA jda;

    public void start() throws Exception {
        manager.getFileManager().init();
        manager.getConfigManager().init();
        manager.getCommandManager().init();
        if (manager.getConfigManager().getConfig().getAsString("token").isEmpty()) throw new IllegalStateException("Token is empty!");
        jda = JDABuilder.createDefault(manager.getConfigManager().getConfig().getAsString("token")).build();
        jda.addEventListener(manager.getCommandManager());
        jda.awaitReady();
    }

    public static DiscordBot getInstance() {
        if (INSTANCE == null)
            INSTANCE = new DiscordBot();
        return INSTANCE;
    }

}