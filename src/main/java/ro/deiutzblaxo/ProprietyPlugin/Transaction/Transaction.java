package ro.deiutzblaxo.ProprietyPlugin.Transaction;

import java.time.LocalDateTime;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public interface Transaction {

	Player getSeller();

	Player getBuyer();

	double getValue();

	Paralelipiped getPropriety();

	LocalDateTime getTime();


}
