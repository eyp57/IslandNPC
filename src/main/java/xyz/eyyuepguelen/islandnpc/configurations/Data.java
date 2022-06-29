package xyz.eyyuepguelen.islandnpc.configurations;

import org.bukkit.configuration.file.YamlConfiguration;
import xyz.eyyuepguelen.islandnpc.IslandNPC;

import java.io.File;

public class Data extends YamlConfiguration {
    private File file;
    private IslandNPC main;

    public Data(IslandNPC main){
        this.main = main;
        file = new File(main.getDataFolder(), "data.yml");

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            main.saveResource("data.yml", false);
        }
        reload();
    }

    public void reload() {
        try {
            this.load(this.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            this.save(this.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
