package ro.deiutzblaxo.ProprietyPlugin.Land.Events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import ro.deiutzblaxo.ProprietyPlugin.Land.Land;

public class LandCreateEvent extends Event implements Cancellable {
	private static final HandlerList HANDLERS = new HandlerList();


	private Land l = null;
	private boolean isCancelled = false;

	public LandCreateEvent(Land land) {

		this.l = land;

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
