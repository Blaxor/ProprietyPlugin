package ro.deiutzblaxo.ProprietyPlugin.Transaction.Announce;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public interface Announce {

	public Player getOwner();

	public String getName();

	public String getDescrioption();

	public double getValue();

	public AnnounceType getType();

	public Paralelipiped getPropriety();
}
