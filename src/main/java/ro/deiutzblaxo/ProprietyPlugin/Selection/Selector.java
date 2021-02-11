package ro.deiutzblaxo.ProprietyPlugin.Selection;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;

public interface Selector {

	Player getPlayer();

	Vector3 getLeftClick();

	boolean setLeftClick(Vector3 leftClickPos);

	Vector3 getRightClick();

	boolean setRightClick(Vector3 rightClickPos);

	Material getTool();

	boolean setTool(Material material);
}
