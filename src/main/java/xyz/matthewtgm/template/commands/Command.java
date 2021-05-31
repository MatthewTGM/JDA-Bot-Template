package xyz.matthewtgm.template.commands;

import lombok.Getter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command {

    /* Command metadata. */
    @Getter private final String name;
    @Getter private final String registryName;
    @Getter private final CommandCategory category;

    public Command(String name, CommandCategory category) {
        this.name = name;
        this.registryName = name.toLowerCase().replaceAll(" ", "_");
        this.category = category;
    }

    public abstract void onRan(MessageReceivedEvent event, String[] args);

    public abstract String getHelpMessage();

}