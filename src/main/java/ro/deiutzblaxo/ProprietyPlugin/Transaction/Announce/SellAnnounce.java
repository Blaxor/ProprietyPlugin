package ro.deiutzblaxo.ProprietyPlugin.Transaction.Announce;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public class SellAnnounce implements Announce {

	private String name;
	private String description;
	private double value;
	private Paralelipiped propriety;
	@Override
	public String getName() {

		return name;
	}

	@Override
	public String getDescrioption() {

		return description;
	}

	@Override
	public double getValue() {

		return value;
	}

	@Override
	public AnnounceType getType() {

		return AnnounceType.SELL;
	}

	public Paralelipiped getPropriety() {
		return propriety;
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

}
