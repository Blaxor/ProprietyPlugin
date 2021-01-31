package ro.deiutzblaxo.ProprietyPlugin.Land.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import ro.deiutzblaxo.ProprietyPlugin.Land.Land;

public class LandQuitEvent extends Event implements Cancellable {

	private static final HandlerList HANDLERS = new HandlerList();

	private Player p = null;
	private Land l = null;
	private boolean isCancelled = false;

	public LandQuitEvent(Land land, Player player) {

		this.p = player;
		this.l = land;

	}

	public Player getPlayer() {
		return p;
	}

	public Land getRegion() {
		return l;
	}

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}

	public static HandlerList getHandlerList() {
		return HANDLERS;
	}


}
