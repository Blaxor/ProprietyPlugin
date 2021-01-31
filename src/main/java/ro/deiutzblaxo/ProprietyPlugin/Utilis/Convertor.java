package ro.deiutzblaxo.ProprietyPlugin.Utilis;

import org.bukkit.Location;
import org.bukkit.World;

public class Convertor {

	public static Vector3 LocationToVector3(Location loc) {
		return new Vector3(loc.getX(), loc.getY(), loc.getZ());

	}

	public static Location Vector3ToLocation(Vector3 vec, World world) {
		
		return new Location(world, vec.x, vec.y, vec.z);

	}
	public static Vector2 LocationToVector2(Location loc){

		return new Vector2(loc.getX(),loc.getZ());

	}

	public static double convertToPositiveDouble(Double a) {

		if (a < 0) {
			return a * -1;
		} else {
			return a;
		}

	}

	public static int positiveOrNegative(double a) {
		if (a < 0) {
			return -1;
		} else {
			return 1;
		}
	}

}
