package model;

import java.awt.*;
import java.util.Stack;

public class HexSpace implements Space {

	private Space[] neighbors;
	private Location l;
	// TODO what is status?
	public int status;
	public Color color;
	private Stack<Tile> tilesOnSpace;

	public HexSpace(Location l) {
		this.l = l;
		this.neighbors = new Space[6];
		this.status = 0;
		this.color = Color.BLUE;
		tilesOnSpace = new Stack<Tile>();
	}

	public Developer getDeveloper() {
		return null;

	}

	public void removeDeveloper() {

	}

	public int getHeight() {
		return tilesOnSpace.size();
	}

	public Tile getTopTile() {
		return tilesOnSpace.pop();
	}

	public void addTile(Tile tile) {
		tilesOnSpace.push(tile);
	}

	public boolean onBoarder() {
		return (numberOfNeighbors() != 6);

	}

	private int numberOfNeighbors() {

		int number = 0;

		for (Space neighbor : neighbors) {
			if (neighbor != null)
				number++;
		}

		return number;
	}

	public Space[] getNeighbors() {
		return neighbors;

	}

	public void place(Tile tile) {
		if (tilesOnSpace.size() == 0) {
			tilesOnSpace.add(tile);
		} else {
			Tile under = tilesOnSpace.peek();
			under.place(tile, tilesOnSpace);
		}
	}

	public void setNeighbors(int index, Space s) {
		neighbors[index] = s;
	}

	public Location getLocation() {
		return l;
	}

}
