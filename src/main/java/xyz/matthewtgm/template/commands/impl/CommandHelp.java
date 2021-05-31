package xyz.matthewtgm.template.commands.impl;

import xyz.matthewtgm.template.DiscordBot;
import xyz.matthewtgm.template.commands.Command;
import xyz.matthewtgm.template.commands.CommandCategory;
import xyz.matthewtgm.template.utils.MessageHelper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommandHelp extends Command {

    public CommandHelp() {
        super("Help", CommandCategory.UTILITY);
    }

    public void onRan(MessageReceivedEvent event, String[] args) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Help Command")
                .setColor(new Color(252, 212, 0));
        for (CommandCategory category : CommandCategory.values()) {
            StringBuilder sb = new StringBuilder();
            List<Command> commands = getCommands(category);
            if (!commands.isEmpty()) {
                for (Command command : commands)
                    sb.append("__").append(command.getRegistryName()).append("__").append(command.getHelpMessage() == null ? "" : " - " + command.getHelpMessage()).append("\n");
                embed.addField(category.getCategoryName(), sb.toString(), false);
            }
        }
        MessageHelper.sendMsg(event.getTextChannel(), embed);
    }

    public String getHelpMessage() {
        return "Sends this message!";
    }

    private List<Command> getCommands(CommandCategory category) {
        List<Command> ret = new ArrayList<>();
        for (Command command : DiscordBot.getManager().getCommandManager().getCommands())
            if (command.getCategory().equals(category))
                ret.add(command);
        return ret;
    }

}