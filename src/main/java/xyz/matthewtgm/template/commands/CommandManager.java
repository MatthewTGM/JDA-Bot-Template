package xyz.matthewtgm.template.commands;

import lombok.Getter;
import xyz.matthewtgm.template.commands.impl.CommandHelp;
import xyz.matthewtgm.template.commands.impl.CommandPing;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import xyz.matthewtgm.template.DiscordBot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    @Getter private final List<Command> commands = new ArrayList<>();

    public void init() {
        commands.add(new CommandHelp());
        commands.add(new CommandPing());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        try {
            if (event.getAuthor().isBot()) return;
            if (event.isWebhookMessage()) return;
            String prefix = DiscordBot.getManager().getConfigManager().getConfig().getAsString("prefix");
            if (prefix.isEmpty()) throw new IllegalStateException("Prefix is empty!");

            String msg = event.getMessage().getContentDisplay();
            if (!msg.startsWith(prefix)) return;
            String commandName = msg.split(" ")[0].replace(prefix, "");
            String[] args = msg.replace(prefix + commandName, "").trim().split(" ");
            commands.stream().filter(command -> command.getName().equalsIgnoreCase(commandName)).findFirst().ifPresent(command -> command.onRan(event, args));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}