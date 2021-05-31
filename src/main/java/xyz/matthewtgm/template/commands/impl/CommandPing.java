package xyz.matthewtgm.template.commands.impl;

import xyz.matthewtgm.template.commands.Command;
import xyz.matthewtgm.template.commands.CommandCategory;
import xyz.matthewtgm.template.utils.MessageHelper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class CommandPing extends Command {

    public CommandPing() {
        super("Ping", CommandCategory.UTILITY);
    }

    @Override
    public void onRan(MessageReceivedEvent event, String[] args) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Ping")
                .setColor(new Color(252, 212, 0))
                .addField("Gateway Ping", String.valueOf(event.getJDA().getGatewayPing()), true)
                .addField("Rest Ping", String.valueOf(event.getJDA().getRestPing().complete()), true);
        MessageHelper.sendMsg(event.getTextChannel(), embed);
    }

    @Override
    public String getHelpMessage() {
        return "Ping!";
    }

}