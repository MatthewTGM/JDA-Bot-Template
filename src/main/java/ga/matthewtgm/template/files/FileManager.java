package ga.matthewtgm.template.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    public File runDir = new File("run"), configDir = new File(runDir, "config");
    public final List<File> files = new ArrayList<>(Arrays.asList(runDir, configDir));

    public void init() {
        for (File file : this.files)
            if (!file.exists()) file.mkdirs();
    }
}