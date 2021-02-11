package ro.deiutzblaxo.ProprietyPlugin.DB;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ro.deiutzblaxo.ProprietyPlugin.Main.Main;

import java.io.File;
import java.io.IOException;

public class YAMLDatabase {

    private FileConfiguration LocalPlayerFileConfiguration;
    private File PlayerFolder = new File(Main.instance.getDataFolder()+"/database");
    private File LocalPlayerFile = new File(PlayerFolder, "LocalPlayer.yaml");

    private File LandFile = new File(PlayerFolder, "LocalPlayer.yaml");
    private FileConfiguration LandFileConfiguration;

    public YAMLDatabase(){
        if(!PlayerFolder.exists()){
            PlayerFolder.mkdirs();
        }
        if(!LocalPlayerFile.exists()){
            try {
                LocalPlayerFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!LandFile.exists()){
            try {
                LandFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loadPlayers();
    }
    public void loadPlayers(){
        LocalPlayerFileConfiguration = YamlConfiguration.loadConfiguration(LocalPlayerFile);
    }
    public void savePlayers(){

        try {
            LocalPlayerFileConfiguration.save(LocalPlayerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConfiguration getPlayers(){
        return LocalPlayerFileConfiguration;
    }
    public void loadLands(){
        LandFileConfiguration = YamlConfiguration.loadConfiguration(LandFile);
    }
    public void saveLands(){

        try {
            LandFileConfiguration.save(LandFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConfiguration getLands(){
        return LandFileConfiguration;
    }



}
