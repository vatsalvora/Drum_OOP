package controller;

import model.*;

import java.util.ArrayList;

public class BoardController {
	private Board board;
    private DeveloperPathFinding pathFinding;

    public BoardController() {
        board = new Board();
        pathFinding = new DeveloperPathFinding();
    }

    public Board getBoard() {
		return board;
	}

	public void moveDeveloper(Location initial, Location fin) {

	}

    public HexSpace getCurrentSpace(){
        return board.getCurrentSpace();
    }

    public int[] getRotations(){
        return board.getRotations();
    }

    public void setCurrentSpace(HexSpace space){
         board.setCurrentSpace(space);
    }

	public void placeTile(Tile... tile) {
        board.place(tile);
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
        return pathFinding.getShortestPath(board.getSpace(initial), board.getSpace(fin));
	}
	public int shortestPathCost() {
		return pathFinding.getAPUsed();

	}

}
