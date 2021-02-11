package ro.deiutzblaxo.ProprietyPlugin.EventHandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ro.deiutzblaxo.ProprietyPlugin.Player.LocalPlayerService;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void PlayerJoin (org.bukkit.event.player.PlayerJoinEvent event){
        LocalPlayerService.createLocalPlayer(event.getPlayer());

    }
}
