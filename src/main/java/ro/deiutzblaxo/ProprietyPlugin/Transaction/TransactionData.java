package ro.deiutzblaxo.ProprietyPlugin.Transaction;

import java.time.LocalDateTime;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public class TransactionData implements Transaction {

	private final Player seller;
	private final Player buyer;
	private final double value;
	private final Paralelipiped propriety;
	private final LocalDateTime time;

	public TransactionData(Player seller, Player buyer, double value, Paralelipiped propriety, LocalDateTime time) {
		this.seller = seller;
		this.buyer = buyer;
		this.value = value;
		this.propriety = propriety;
		this.time = time;

	}
	@Override
	public Player getSeller() {

		return seller;
	}

	@Override
	public Player getBuyer() {

		return buyer;
	}

	@Override
	public double getValue() {

		return value;
	}

	@Override
	public Paralelipiped getPropriety() {

		return propriety;
	}

	@Override
	public LocalDateTime getTime() {

		return time;
	}

}
