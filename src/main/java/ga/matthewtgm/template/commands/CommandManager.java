package ga.matthewtgm.template.commands;

import ga.matthewtgm.template.DiscordBot;
import ga.matthewtgm.template.commands.impl.CommandHelp;
import ga.matthewtgm.template.commands.impl.CommandPing;
import ga.matthewtgm.template.utils.MessageUtils;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    private List<Command> commands = new ArrayList<>();
    private String prefix;

    public void init() {
        if (prefix == null) {
            DiscordBot main = DiscordBot.getInstance();
            main.getConfigManager().getConfigObj().putIfAbsent("prefix", "!");
            this.prefix = (String) main.getConfigManager().getConfigObj().get("prefix");
            main.getConfigManager().save();
        }

        this.getCommands().add(new CommandHelp());
        this.getCommands().add(new CommandPing());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        try {
            for (Command command : this.getCommands()) {
                String msg = event.getMessage().getContentDisplay();
                String commandName = msg.substring(this.prefix.length(), msg.split(" ")[0].length());
                String[] args = msg.substring(commandName.length() + 2).split(" ");
                if(msg.startsWith(this.prefix) && command.getName().equalsIgnoreCase(commandName) && !event.getAuthor().isBot() && !event.isWebhookMessage()) {
                    command.onRan(event, args, MessageUtils.getInstance());
                }
            }
        } catch (Exception e) {
            if (e instanceof StringIndexOutOfBoundsException) return;
            e.printStackTrace();
        }
    }

    public List<Command> getCommands() {
        return commands;
    }

    public String getPrefix() {
        return prefix;
    }

}