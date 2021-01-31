package ro.deiutzblaxo.ProprietyPlugin.Land;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.Land.Events.LandCreateEvent;
import ro.deiutzblaxo.ProprietyPlugin.Player.LocalPlayer;
import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public class LandService {
	



	private ArrayList<LandData> lands = new ArrayList<LandData>();

	public  ArrayList<LandData> getLands() {
		return lands;
	}

	public boolean createLand(Player player ,Paralelipiped paral) {
		Land land = new LandData(player, paral);
		lands.add((LandData) land);
		Bukkit.getPluginManager().callEvent(new LandCreateEvent(land));
		return true;
	}

	public boolean addAdministrator(Player owner , Player newAdmin) {
		if (owner == null || newAdmin == null) {
			throw new NullPointerException();
		}
		Land land = findLandByOwner(owner);
		if(land != null) {
			return land.addAdministrator(newAdmin);
		}
		return false;
	}

	public Land findLandByOwner(Player owner) {
		
		for(Land land : lands) {
			if (land.getOwner().equals(owner)) {
				return land;
			}
		}
		return null;
		
	}
	public Land findLandByOwner(LocalPlayer owner){
		return  owner.getLand();
	}
	public List<Land> findLandsByAdmin(LocalPlayer admin){
		return admin.getAdministratorLand();
	}

}
