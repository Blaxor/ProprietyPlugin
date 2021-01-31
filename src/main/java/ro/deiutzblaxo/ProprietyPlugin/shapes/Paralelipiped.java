package ro.deiutzblaxo.ProprietyPlugin.shapes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;

import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector2;
import ro.deiutzblaxo.ProprietyPlugin.Utilis.Vector3;

public class Paralelipiped implements Comparable<Paralelipiped> {
	public Vector2 NodeTopRight;
	public Vector2 NodeBottomLeft;
	public Vector2 NodeTopLeft;
	public Vector2 NodeBottomRight;
	private float lowestY;
	private float highestY;
	public World world;

	public Paralelipiped(Vector2 left, Vector2 right, float y1, float y2, World world) {

		this.world = world;
		if (left.getY() >= right.getY()) {
			NodeTopLeft = left;
			NodeBottomRight = right;
		} else {
			NodeTopLeft = right;
			NodeBottomRight = left;
		}
		if (y1 > y2) {
			highestY = y1;
			lowestY = y2;
		} else {
			highestY = y2;
			lowestY = y1;
		}

		NodeTopRight = new Vector2(NodeBottomRight.getX(), NodeTopLeft.getY());
		NodeBottomLeft = new Vector2(NodeTopLeft.getX(), NodeBottomRight.getY());
	}

//	public boolean checkInRegion(Location loc, Location block1, Location block2) {
//		int x1 = Math.min(block1.getBlockX(), block2.getBlockX());
//		int y1 = Math.min(block1.getBlockY(), block2.getBlockY());
//		int z1 = Math.min(block1.getBlockZ(), block2.getBlockZ());
//		int x2 = Math.max(block1.getBlockX(), block2.getBlockX());
//		int y2 = Math.max(block1.getBlockY(), block2.getBlockY());
//		int z2 = Math.max(block1.getBlockZ(), block2.getBlockZ());
//
//		return loc.getBlockX() >= x1 && loc.getBlockX() <= x2 && loc.getBlockY() >= y1 && loc.getBlockY() <= y2
//				&& loc.getBlockZ() >= z1 && loc.getBlockZ() <= z2;
//	}


	public Vector3 getMiddle() {
		Vector3 left = new Vector3(NodeTopRight, getHighestY());
		Vector3 right = new Vector3(NodeBottomLeft, getLowestY());
		Vector3 add = Vector3.add(left, right);
		return new Vector3(add.getX() / 2, add.getY() / 2, add.getZ() / 2);
	}
	public List<Vector3> getAllCornerNodes() {
		List<Vector3> a = new ArrayList<Vector3>();
		a.add(new Vector3(NodeTopLeft, getHighestY())); // east
		a.add(new Vector3(NodeTopRight, getHighestY())); // set 2
		a.add(new Vector3(NodeBottomLeft, getHighestY())); // east
		a.add(new Vector3(NodeBottomRight, getHighestY())); // set 2
		a.add(new Vector3(NodeTopLeft, getLowestY()));
		a.add(new Vector3(NodeTopRight, getLowestY()));
		a.add(new Vector3(NodeBottomLeft, getLowestY()));
		a.add(new Vector3(NodeBottomRight, getLowestY()));

		return a;
	}
	
	

	public List<Vector3> getAllNodes() {
		List<Vector3> a = new ArrayList<Vector3>();

		for (float y = getLowestY(); y <= getHighestY(); y++) {

			for (float z = getLower(NodeTopRight.getY(), NodeBottomRight.getY()); z <= getHigher(NodeTopRight.getY(),
					NodeBottomRight.getY()); z++) {

				for (float x = getLower(NodeTopRight.getX(), NodeTopLeft.getX()); x <= getHigher(NodeTopRight.getX(),
						NodeTopLeft.getX()); x++) {

					a.add(new Vector3(x, y, z));
				}
			}

		}
		return a;

	}

	public List<Vector3> getWallsNodes() {
		List<Vector3> a = new ArrayList<Vector3>();
		getBorderSouth().forEach(vec -> {

			a.add(vec);
		});
		getBorderNorth().forEach(vec -> {

			a.add(vec);
		});
		getBorderWest().forEach(vec -> {
			a.add(vec);
		});
		getBorderEast().forEach(vec -> {
			a.add(vec);
		});

		return a;
	}
	public List<Vector3> getBoxNodes(){
		List<Vector3> a = getWallsNodes();
		getRoof().forEach(vec -> {

			a.add(vec);
		});
		getFloor().forEach(vec -> {

			a.add(vec);
		});


		return a;
	}

	private List<Vector3> getBorderSouth() {
		List<Vector3> a = new ArrayList<Vector3>();
		for (float y = getLowestY(); y <= getHighestY(); y++) {
		
			for (float x = getLower(NodeTopRight.getX(), NodeTopLeft.getX()); x <= getHigher(NodeTopRight.getX(),
					NodeTopLeft.getX()); x++) {
				
				a.add(new Vector3(x, y, NodeTopRight.getY()));
			}
		}
		return a;
	}

	private List<Vector3> getBorderNorth() {
		List<Vector3> a = new ArrayList<Vector3>();
		for (float y = getLowestY(); y <= getHighestY(); y++) {

			for (float x = getLower(NodeBottomRight.getX(), NodeBottomLeft.getX()); x <= getHigher(
					NodeBottomRight.getX(), NodeTopLeft.getX()); x++) {
			
				a.add(new Vector3(x, y, NodeBottomRight.getY()));
			}
		}
		return a;
	}

	private List<Vector3> getBorderEast(){
		List<Vector3> a = new ArrayList<Vector3>();
		for (float y = getLowestY(); y <= getHighestY(); y++) {
			for (float z = getLower(NodeTopLeft.getY(), NodeBottomLeft.getY()); z <= getHigher(NodeTopLeft.getY(),
					NodeBottomLeft.getY()); z++) {

				a.add(new Vector3(NodeTopLeft.getX(), y, z));

			}
		}
		return a;
	}

	private List<Vector3> getBorderWest() {
		List<Vector3> a = new ArrayList<Vector3>();
		for (float y = getLowestY(); y <= getHighestY(); y++) {
			for (float z = getLower(NodeTopRight.getY(), NodeBottomRight.getY()); z <= getHigher(NodeTopRight.getY(),
					NodeBottomRight.getY()); z++) {

				a.add(new Vector3(NodeTopRight.getX(), y, z));

			}
		}
		return a;
	}

	private List<Vector3> getFloor() {
		List<Vector3> a = new ArrayList<Vector3>();
		for (float z = getLower(NodeTopRight.getY(), NodeBottomRight.getY()); z <= getHigher(NodeTopRight.getY(),
				NodeBottomRight.getY()); z++) {

			for (float x = getLower(NodeTopRight.getX(), NodeTopLeft.getX()); x <= getHigher(NodeTopRight.getX(),
					NodeTopLeft.getX()); x++) {

				a.add(new Vector3(x, getLowestY(), z));
			}
		}
		return a;
	}

	private List<Vector3> getRoof() {
		List<Vector3> a = new ArrayList<Vector3>();
		for (float z = getLower(NodeTopRight.getY(), NodeBottomRight.getY()); z <= getHigher(NodeTopRight.getY(),
				NodeBottomRight.getY()); z++) {

			for (float x = getLower(NodeTopRight.getX(), NodeTopLeft.getX()); x <= getHigher(NodeTopRight.getX(),
					NodeTopLeft.getX()); x++) {

				a.add(new Vector3(x, getHighestY(), z));
			}
		}
		return a;
	}




	private float getHigher(float a, float b) {
		return a > b ? a : b;
	}

	private float getLower(float a, float b) {
		return a < b ? a : b;
	}

	@Override
	public String toString() {

		return "NodeTopLeft:" + NodeTopLeft + "\n NodeTopRight:" + "\n NodeBottomRight" + NodeBottomRight;
	}

	public float getLowestY() {
		return lowestY;
	}

	public float getHighestY() {
		return highestY;
	}
	
//	public boolean isInArea(org.bukkit.Location loc) {
//	    Vector3 vec = NodeTopRight.toVector3(getHighestY());
//		Vector3 vec1 = NodeBottomLeft.toVector3(getLowestY());
//		return (
//	    		vec.getX() <= loc.getX()
//	        && vec.getY() <= loc.getY()
//	        && vec.getZ() <= loc.getZ()
//	        
//	        && vec1.getX() >= loc.getX()
//	        && vec1.getY() >= loc.getY()
//	        && vec1.getZ() >= loc.getZ()
//	    );
//	}

	@Override
	public int compareTo(Paralelipiped args) {

		return (int) (Math.pow(getMiddle().getX() * getMiddle().getY() + getMiddle().getZ(), 2)
				- Math.pow((getMiddle().getX() * getMiddle().getY() + getMiddle().getZ()), 2));

	}
}
