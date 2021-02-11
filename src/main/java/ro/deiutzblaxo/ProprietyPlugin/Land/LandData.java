/**
 * 
 */
package ro.deiutzblaxo.ProprietyPlugin.Land;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ro.deiutzblaxo.ProprietyPlugin.Land.Events.LandJoinEvent;
import ro.deiutzblaxo.ProprietyPlugin.Land.Events.LandQuitEvent;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Convertor;
import ro.deiutzblaxo.ProprietyPlugin.shapes.Paralelipiped;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deiutz
 *
 */
public class LandData implements Land {
	private static final LAND_FLAGS[] DEFAULT_FLAGS = { LAND_FLAGS.PLACE, LAND_FLAGS.BREAK, LAND_FLAGS.ENTER };
	private final String ID;
	private final Player owner;
	private final List<Player> administrators = new ArrayList<Player>();
	private final Paralelipiped paral;
	private double value = 0;
	private final List<Player> inProt = new ArrayList<Player>();
	private final List<LAND_FLAGS> flags = new ArrayList<LAND_FLAGS>();

	public LandData(Player owner, Paralelipiped size) {
		
		for (int i = 0; i < DEFAULT_FLAGS.length; i++)
			flags.add(DEFAULT_FLAGS[i]);
		this.owner = owner;
		paral = size;
		ID = paral.getMiddle().toString();
	}

	@Override
	public String getID() {
		return paral.toString();
	}

	@Override
	public Player getOwner() {

		return owner;
	}

	@Override
	public List<Player> getAdministrators() {

	 return administrators;
	}

	@Override
	public Paralelipiped getSize() {

		return paral;
	}

	@Override
	public double getValue() {

		return value;
	}

	@Override
	public void setValue(double money) {
		this.value = money;

	}

	@Override
	public boolean addAdministrator(Player player) {
		if (administrators.contains(player)) {
			return false;
		} else {
			administrators.add(player);
			return true;
		}

	}

	@Override
	public void callJoinEvent(Player player) {


		if (paral.getBoxNodes().contains(Convertor.LocationToVector3(player.getLocation()))
				&& !inProt.contains(player)) {
				Bukkit.getPluginManager().callEvent(new LandJoinEvent(this, player));
				inProt.add(player);

		}
	}


	@Override
	public void callQuitEvent(Player player) {
		if (!paral.getBoxNodes().contains(Convertor.LocationToVector3(player.getLocation()))
				&& inProt.contains(player)) {
			inProt.remove(player);
			Bukkit.getPluginManager().callEvent(new LandQuitEvent(this, player));
		}
	}

	@Override
	public List<LAND_FLAGS> getFlags() {

		return flags;
	}

}
