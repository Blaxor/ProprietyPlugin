package ro.deiutzblaxo.ProprietyPlugin.Selection;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;

public interface Selector {

	public Player getPlayer();

	public Vector3 getLeftClick();

	public boolean setLeftClick(Vector3 leftClickPos);

	public Vector3 getRightClick();

	public boolean setRightClick(Vector3 rightClickPos);

	public Material getTool();

	public boolean setTool(Material material);
}
