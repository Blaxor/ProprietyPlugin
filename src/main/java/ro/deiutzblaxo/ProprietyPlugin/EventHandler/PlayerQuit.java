package ro.deiutzblaxo.ProprietyPlugin.EventHandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import ro.deiutzblaxo.ProprietyPlugin.Land.Land;
import ro.deiutzblaxo.ProprietyPlugin.Land.Events.LandQuitEvent;
import ro.deiutzblaxo.ProprietyPlugin.Main.Main;
import ro.deiutzblaxo.ProprietyPlugin.Player.LocalPlayerService;

public class PlayerQuit implements Listener {
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Main.selectorService.removeSelector(e.getPlayer());
		for (Land land : Main.landService.getLands()) {
			land.callQuitEvent(e.getPlayer());
		}
		LocalPlayerService.removeLocalPlayer(e.getPlayer());


	}

	@EventHandler
	public void LandQuitEvent(LandQuitEvent e) {
		e.getPlayer().sendMessage("Leaving " + e.getPlayer().getDisplayName() + "'s land");
	}
}
