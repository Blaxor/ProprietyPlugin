package ro.deiutzblaxo.ProprietyPlugin.Selection;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;

public class SelectorData implements Selector {
	private Player player;
	private Vector3 leftClickPos;
	private Vector3 rightClickPos;
	private Material tool;

	public SelectorData(Player p) {
		player = p;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public Vector3 getLeftClick() {
		
		return leftClickPos;
	}

	@Override
	public boolean setLeftClick(Vector3 leftClickPos) {
		if (leftClickPos.equals(this.leftClickPos))
			return false;
		this.leftClickPos = leftClickPos;
		return true;
	}

	@Override
	public Vector3 getRightClick() {
		
		return rightClickPos;
	}

	@Override
	public boolean setRightClick(Vector3 rightClickPos) {
		if (rightClickPos.equals(this.rightClickPos))
			return false;

		this.rightClickPos = rightClickPos;
		return true;
	}

	@Override
	public Material getTool() {
		
		return tool;
	}

	@Override
	public boolean setTool(Material material) {
		if (material.equals(this.tool))
			return false;
		this.tool = material;
		return true;
	}

}
