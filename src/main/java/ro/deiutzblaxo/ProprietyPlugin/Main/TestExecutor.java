package ro.deiutzblaxo.ProprietyPlugin.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.Utilis.Convertor;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;
import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public class TestExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

		try {
		Player p = (Player) sender;
		Paralelipiped paral = Main.selectorService.getParalelipiped(p);

		p.sendBlockChange(Convertor.Vector3ToLocation(paral.getMiddle(), p.getWorld()),
				Bukkit.createBlockData(Material.GLOWSTONE));

		Main.landService.createLand(p, paral);

		for (Vector3 vector : paral.getAllCornerNodes()) {
			p.sendBlockChange(Convertor.Vector3ToLocation(vector, p.getWorld()),
					Bukkit.createBlockData(Material.GLOWSTONE));
		}


		sender.sendMessage("Land have been created");

	} catch (NullPointerException e) {
		sender.sendMessage("Please select 2 positions! Using left-click and right-click!");
	}
		return false;
	}

}
