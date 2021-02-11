package ro.deiutzblaxo.ProprietyPlugin.EventHandler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ro.deiutzblaxo.ProprietyPlugin.Land.Events.LandJoinEvent;
import ro.deiutzblaxo.ProprietyPlugin.Land.Land;
import ro.deiutzblaxo.ProprietyPlugin.Main.Main;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Convertor;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;

import java.util.HashMap;

public class PlayerMoveEvent implements Listener {

	protected static final HashMap<Player, Vector3> LAST_LOCATION = new HashMap<Player, Vector3>();
	@EventHandler
	public void test(org.bukkit.event.player.PlayerMoveEvent event) {

		if (LAST_LOCATION.containsKey(event.getPlayer())) {
			Vector3 lastLocation = Convertor.LocationToVector3(event.getPlayer().getLocation());
			if (lastLocation.equals(LAST_LOCATION.get(event.getPlayer()))) {
				return;
			} else {
				LAST_LOCATION.put(event.getPlayer(), lastLocation);

				for (Land land : Main.landService.getLands()) {
					land.callJoinEvent(event.getPlayer());
					land.callQuitEvent(event.getPlayer());
				}
			}
		} else {
			LAST_LOCATION.put(event.getPlayer(), Convertor.LocationToVector3(event.getPlayer().getLocation()));
		}




		

	}

	@EventHandler
	public void landJoinEvent(LandJoinEvent event) {
		event.getPlayer().sendMessage("You joined in " + event.getRegion().getOwner().getDisplayName() + "' land");
	}


}
