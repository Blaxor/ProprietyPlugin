package ro.deiutzblaxo.ProprietyPlugin.Transaction.Announce;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public class BuyAnnounce implements Announce {

	private String name;
	private String description;
	private double value;
	private Paralelipiped propriety;
	private Player player;


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

		return AnnounceType.BUY;
	}

	@Override
	public Paralelipiped getPropriety() {
		// TODO Auto-generated method stub
		return propriety;
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return player;
	}

}
