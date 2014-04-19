package controller;

import model.*;

import java.util.ArrayList;

public class BoardController {
	private Board board;

    public BoardController() {
        board = new Board();
    }

    public Board getBoard() {
		return board;
	}

	public void moveDeveloper(Location initial, Location fin) {

	}

    public HexSpace getCurrentSpace(){
        return board.getCurrentSpace();
    }
	public void placeTile(Location location, Tile tile) {
        board.place(location, tile);
	}

	public boolean checkTilePlacement(Location location, Tile tile) {
		return false;
	}

	public boolean checkDevPlacement(Location location, Developer developer) {
		return false;
	}

	public boolean checkMovement(Location initial, Location fin) {
		return false;

	}

	public void removeDeveloper(Developer developer) {

	}

	public Developer checkHighestDeveloper(Location location) {
		return null;

	}

	public ArrayList<Space> shortestPath(Location initial, Location fin) {
		DeveloperPathFinding developerPathFinding = new DeveloperPathFinding();
return null;

	}

	public int shortestPathCost() {
		return 0;

	}

}
