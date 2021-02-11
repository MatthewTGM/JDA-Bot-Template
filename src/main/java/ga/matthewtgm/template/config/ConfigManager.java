package ga.matthewtgm.template.config;

import ga.matthewtgm.json.files.JsonReader;
import ga.matthewtgm.json.files.JsonWriter;
import ga.matthewtgm.json.objects.JsonObject;
import ga.matthewtgm.template.DiscordBot;

public class ConfigManager {

    private JsonObject configObj;

    public void init() {
        if (this.getConfigObj() == null) {
            boolean isConfigNull = JsonReader.readObj("config", DiscordBot.getInstance().getFileManager().configDir) == null;

            if(isConfigNull) this.configObj = new JsonObject();
            else this.configObj = JsonReader.readObj("config", DiscordBot.getInstance().getFileManager().configDir);
        }
    }

    public void save() {
        JsonWriter.write("config", this.getConfigObj(), DiscordBot.getInstance().getFileManager().configDir);
    }

    public JsonObject getConfigObj() {
        return configObj;
    }

}