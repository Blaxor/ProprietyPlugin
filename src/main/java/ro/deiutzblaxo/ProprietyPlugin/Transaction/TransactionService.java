package ro.deiutzblaxo.ProprietyPlugin.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.Transaction.Announce.Announce;

public class TransactionService {

	private List<TransactionData> Transactions = new ArrayList<TransactionData>();
	public void doTransation(Announce announce, Player player) {
		
		Transactions.add(new TransactionData(announce.getOwner(), player, announce.getValue(), announce.getPropriety(),
				LocalDateTime.now()));

	}
	
	

}
