package ro.deiutzblaxo.ProprietyPlugin.Transaction.Announce;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public interface Announce {

	Player getOwner();

	String getName();

	String getDescrioption();

	double getValue();

	AnnounceType getType();

	Paralelipiped getPropriety();
}
