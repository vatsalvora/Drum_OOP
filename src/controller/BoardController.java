package controller;

import model.*;

import java.util.List;

public class BoardController {
	private Board board;

    public BoardController() {

    }

    public BoardController(Board board) {
        this.board = board;
    }

    public Board getBoard() {
		return board;
	}

	public void moveDeveloper(Location initial, Location fin) {

	}

	public void placeTile(Location location, Tile tile) {

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

	public List<Space> shortestPath() {
		return null;

	}

	public int shortestPathCost() {
		return 0;

	}

}
