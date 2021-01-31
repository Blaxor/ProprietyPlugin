package ro.deiutzblaxo.ProprietyPlugin.Land;

import java.util.List;

import org.bukkit.entity.Player;

import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

public interface Land {

	Player getOwner();

	List<LAND_FLAGS> getFlags();

	List<Player> getAdministrators();


	Paralelipiped getSize();

	public String getID();

	double getValue();

	void setValue(double money);

	boolean addAdministrator(Player player);

	void callJoinEvent(Player player);
	// TODO CALL QUIT EVENT , NEW LAND CREATED , CALL LAND DESTROY ,

	void callQuitEvent(Player player);
}
