import ga.matthewtgm.template.DiscordBot;

public class Start {

    public static void main(String[] args) {
        try {
            DiscordBot.getInstance().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}