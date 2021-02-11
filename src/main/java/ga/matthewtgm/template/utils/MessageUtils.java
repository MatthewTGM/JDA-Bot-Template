package ga.matthewtgm.template.utils;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class MessageUtils {

    private static MessageUtils INSTANCE;

    public static MessageUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MessageUtils();
        return INSTANCE;
    }

    public void sendMessage(TextChannel channel, String msg) {
        channel.sendMessage(msg).queue();
    }

    public void sendMessage(TextChannel channel, Message msg) {
        channel.sendMessage(msg).queue();
    }

    public void sendMessage(TextChannel channel, MessageEmbed embed) {
        channel.sendMessage(embed).queue();
    }

}