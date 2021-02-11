package ro.deiutzblaxo.ProprietyPlugin.DB;

import org.bukkit.entity.Player;
import ro.deiutzblaxo.ProprietyPlugin.Land.Land;
import ro.deiutzblaxo.ProprietyPlugin.Main.Main;
import ro.deiutzblaxo.ProprietyPlugin.Player.LocalPlayerData;

public class DataBaseService {

    private boolean isSQL = false;
    YAMLDatabase database;

    public DataBaseService(){

        if(Main.instance.getConfig().getBoolean("MySQL")){
        isSQL = true;
            //TODO LOAD MYSQL
        }else{
            isSQL = false;
            database = new YAMLDatabase();
        }
    }
    public LocalPlayerData getLocalPlayerData(Player player){
        if(contains(player)){
        return new LocalPlayerData(player);
        }else{
            return null;
        }
    }
    public boolean contains(Player player){
        if(isSQL){
            return false;
        }else{
           return database.getPlayers().getString(player.getUniqueId().toString()) != null;
        }
    }
    public Land getLand()
}
