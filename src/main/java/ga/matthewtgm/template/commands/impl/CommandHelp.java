package ga.matthewtgm.template.commands.impl;

import ga.matthewtgm.template.DiscordBot;
import ga.matthewtgm.template.commands.Command;
import ga.matthewtgm.template.commands.CommandCategory;
import ga.matthewtgm.template.utils.MessageUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class CommandHelp extends Command {

    public CommandHelp() {
        super("Help", CommandCategory.UTILITY);
    }

    @Override
    public void onRan(MessageReceivedEvent event, MessageUtils mUtils) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Help Command")
                .setColor(new Color(252, 212, 0));
        for (CommandCategory category : CommandCategory.values()) {
            StringBuilder sb = new StringBuilder();
            for (Command command : DiscordBot.getInstance().getCommandManager().getCommands()) {
                if (command.getCategory() == category) {
                    sb.append("__" + command.getRegistryName() + "__" + (command.getHelpMessage() == null ? "" : " - " + command.getHelpMessage()) + "\n");
                }
            }
            embed.addField(category.getCategoryName(), sb.toString(), false);
        }
        mUtils.sendMessage(event.getTextChannel(), embed.build());
    }

    @Override
    public String getHelpMessage() {
        return "Sends this message!";
    }

}