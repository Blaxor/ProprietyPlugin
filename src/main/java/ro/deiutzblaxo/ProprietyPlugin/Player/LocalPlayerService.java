package ro.deiutzblaxo.ProprietyPlugin.Player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LocalPlayerService {

    private static final List<LocalPlayer> LOCAL_PLAYERS = new ArrayList<>();

    public static LocalPlayer getLocalPlayer(Player player) {

        for (LocalPlayer LP : LOCAL_PLAYERS) {
            if (LP.getPlayer().equals(player)) {
                return LP;
            }
        }
        return null;
    }
    public static void createLocalPlayer(Player player){
        LOCAL_PLAYERS.add(new LocalPlayerData(player));
    }
    public static boolean containPlayer(Player player){

        return getLocalPlayer(player) != null;

    }
    public static void removeLocalPlayer(Player player){
        if(containPlayer(player))
            LOCAL_PLAYERS.remove(getLocalPlayer(player));
    }


}
