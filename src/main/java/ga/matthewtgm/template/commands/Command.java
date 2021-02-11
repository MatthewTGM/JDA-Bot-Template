package ga.matthewtgm.template.commands;

import ga.matthewtgm.template.utils.MessageUtils;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command {

    // COMMAND INFORMATION
    private String name;
    private String registryName;
    private CommandCategory category;

    // OTHER INFO
    private String helpMessage;

    public Command(String name, CommandCategory category) {
        this.name = name;
        this.registryName = name.toLowerCase();
        this.category = category;
    }

    public abstract void onRan(MessageReceivedEvent event, MessageUtils mUtils);

    public String getName() {
        return name;
    }

    public String getRegistryName() {
        return registryName;
    }

    public CommandCategory getCategory() {
        return category;
    }

    public String getHelpMessage() {
        return helpMessage;
    }

}