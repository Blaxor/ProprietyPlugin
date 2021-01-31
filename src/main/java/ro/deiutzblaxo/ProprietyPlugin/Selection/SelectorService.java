package ro.deiutzblaxo.ProprietyPlugin.Selection;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;
import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public class SelectorService {

	private HashMap<Player, Selector> selectors = new HashMap<Player, Selector>();

	public boolean createSelector(Player player) {

		if (selectors.containsKey(player)) {
			return false;
		}
		selectors.put(player, new SelectorData(player));
		return true;
	}

	public void addPosition(Player player, Vector3 vector, Action action) {
		if (selectors.containsKey(player)) {
			Selector selector = selectors.get(player);

			switch (action) {
			case LEFT_CLICK_BLOCK:
				if (selector.setLeftClick(vector)) {
				// TODO MESSAGE
				player.sendMessage("First Position setted at" + vector);
			}
			break;
			case RIGHT_CLICK_BLOCK:
				if (selector.setRightClick(vector)) {
				// TODO Message
				player.sendMessage("Second Position setted at" + vector);
			}
			break;
				
			default:
			break;

			}
		} else {
			createSelector(player);
			addPosition(player, vector, action);
		}
	}

	public Selector getSelector(Player player) {
		if (selectors.containsKey(player)) {
			return selectors.get(player);
		}
		createSelector(player);
		return getSelector(player);
	}

	public boolean removeSelector(Player player) {
		if (selectors.containsKey(player)) {
		selectors.remove(player);
			return true;
		}
		return false;
	}

	public Paralelipiped getParalelipiped(Player player) {
		if (selectors.containsKey(player)) {
			Selector selector = selectors.get(player);
			if (selector.getLeftClick() == null || selector.getRightClick() == null) {
				throw new NullPointerException();
			}
			return new Paralelipiped(selector.getLeftClick().toVector2(), selector.getRightClick().toVector2(),
					selector.getLeftClick().getY(), selector.getRightClick().getY(), player.getWorld());
		}
		throw new NullPointerException();

	}
}
