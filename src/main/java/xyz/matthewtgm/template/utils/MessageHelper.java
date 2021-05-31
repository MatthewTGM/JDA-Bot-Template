package xyz.matthewtgm.template.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class MessageHelper {

    public static void sendMsg(TextChannel channel, String msg) {
        channel.sendMessage(msg).queue();
    }

    public static void sendMsg(TextChannel channel, Message msg) {
        channel.sendMessage(msg).queue();
    }

    public static void sendMsg(TextChannel channel, MessageEmbed embed) {
        channel.sendMessage(embed).queue();
    }

    public static void sendMsg(TextChannel channel, EmbedBuilder builder) {
        channel.sendMessage(builder.build()).queue();
    }

}