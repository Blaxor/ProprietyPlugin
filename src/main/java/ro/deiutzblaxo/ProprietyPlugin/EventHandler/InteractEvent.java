package ro.deiutzblaxo.ProprietyPlugin.EventHandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import ro.deiutzblaxo.ProprietyPlugin.Land.Events.LandCreateEvent;
import ro.deiutzblaxo.ProprietyPlugin.Main.Main;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Convertor;

public class InteractEvent implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getClickedBlock() == null) {
			return;
		}

		Main.selectorService.addPosition(e.getPlayer(), Convertor.LocationToVector3(e.getClickedBlock().getLocation()),
				e.getAction());

	}

	@EventHandler
	public void onLandCreate(LandCreateEvent e) {
		e.getRegion().getOwner().sendMessage("Land has been created!");
	}



}
