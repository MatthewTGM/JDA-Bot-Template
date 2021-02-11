package ga.matthewtgm.template.commands.impl;

import ga.matthewtgm.template.commands.Command;
import ga.matthewtgm.template.commands.CommandCategory;
import ga.matthewtgm.template.utils.MessageUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class CommandPing extends Command {

    public CommandPing() {
        super("Ping", CommandCategory.UTILITY);
    }

    @Override
    public void onRan(MessageReceivedEvent event, MessageUtils mUtils) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Ping")
                .setColor(new Color(252, 212, 0))
                .addField("Gateway Ping", String.valueOf(event.getJDA().getGatewayPing()), true)
                .addField("Rest Ping", String.valueOf(event.getJDA().getRestPing().complete()), true);
        mUtils.sendMessage(event.getTextChannel(), embed.build());
    }

    @Override
    public String getHelpMessage() {
        return "Ping!";
    }

}