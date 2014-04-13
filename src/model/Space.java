package model;

public class Space {
	private Space[] neighbors;
	private Location l;

	public Space(Location l) {
		this.l = l;
		this.neighbors = new Space[6];
	}

	public Developer getDeveloper() {
		return null;

	}

	public void removeDeveloper() {

	}

	public int getHeight() {
		return 0;

	}

	public Tile getTopTile() {
		return null;

	}

	public boolean onBoarder() {
		return false;

	}

	public Space[] getNeighbors() {
		return neighbors;

	}

}
