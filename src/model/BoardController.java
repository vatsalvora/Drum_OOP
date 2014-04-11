package model;

import java.util.List;

public class BoardController {
	private Board b;

	public BoardController(Board b) {
		this.b = b;
	}

	Board getBoard() {
		return b;
	}

	public void moveDeveloper(Location initial, Location fin) {

	}

	public void placeTile(Location l, Tile t) {

	}

	public boolean checkTilePlacement(Location l, Tile t) {
		return false;

	}

	public boolean checkDevPlacement(Location l, Developer d) {
		return false;

	}

	public boolean checkMovement(Location initial, Location fin) {
		return false;

	}

	public void removeDeveloper(Developer d) {

	}

	public Developer checkHighestDeveloper(Location l) {
		return null;

	}

	public List<Space> shortestPath() {
		return null;

	}

	public int shortestPathCost() {
		return 0;

	}

}
