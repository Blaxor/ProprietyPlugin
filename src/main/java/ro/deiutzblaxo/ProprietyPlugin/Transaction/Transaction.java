package ro.deiutzblaxo.ProprietyPlugin.Transaction;

import java.time.LocalDateTime;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public interface Transaction {

	public Player getSeller();

	public Player getBuyer();

	public double getValue();

	public Paralelipiped getPropriety();

	public LocalDateTime getTime();


}
