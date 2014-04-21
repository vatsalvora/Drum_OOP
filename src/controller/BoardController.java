package controller;

import model.*;
import model.customExceptions.*;

import java.util.ArrayList;

public class BoardController {
	private Board board;
    private DeveloperPathFinding pathFinding;
    private Developer currentDeveloper;
    private Location currentDevLocation;

    public BoardController() {
        board = new Board();
        pathFinding = new DeveloperPathFinding();
        currentDeveloper = null;
        currentDevLocation = null;
    }

    public Board getBoard() {
		return board;
	}

	public void moveDeveloper() throws Exception{
        HexSpace s = (HexSpace) board.getSpace(currentDevLocation);
        if(!board.getCurrentSpace().hasDeveloper())
        {
            board.getCurrentSpace().placeDeveloper(s.getDeveloper());
        }
        else
        {
            throw new DevOnSpaceException();
        }
	}

    public HexSpace getCurrentSpace(){
        return board.getCurrentSpace();
    }

    public void undoTilePlacement(){board.undoTilePlacement();}

    public int[] getRotations(){
        return board.getRotations();
    }

    public void setRotations(int[] rotations){
        board.setRotations(rotations);
    }

    public void setCurrentSpace(HexSpace space){
         board.setCurrentSpace(space);
    }

	public void placeTile(Tile tile) {
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

    public int placeDeveloper(Developer d) throws Exception
    {
        //place developer at current location
        HexSpace currentSpace = board.getCurrentSpace();

        if(currentSpace.onEdge())

        {
            if(!currentSpace.spaceEmpty()) {
                currentSpace.placeDeveloper(d);
            }
            else
            {
                throw new SpaceIsEmptyException();
            }
        }
        else
        {
            throw new SpaceNotOnEdgeException();
        }
        //return AP used based on location
        int APUsed;
        if(currentSpace.getLocation().getYLocation() < 5)
        {
            APUsed = 2;
        }
        else
        {
            APUsed = 1;
        }
        return APUsed;
    }

	public int removeDeveloper(String c) throws Exception{
        //compare the developer color with the given color
        HexSpace currentSpace = board.getCurrentSpace();
        if(currentSpace.getDeveloper() != null)
        {

            if(currentSpace.onEdge()) {

                if (currentSpace.getDeveloper().getColor().compareTo(c) == 0) {
                    currentSpace.removeDeveloper();
                } else {
                    throw new WrongDeveloperColorException();
                }
            }
            else
            {
                throw new SpaceNotOnEdgeException();
            }
        }
        else
        {
            throw new NoDeveloperOnSpaceException();
        }
        //remove developer if of that color
        //return AP used based on location
        int APUsed;
        if(currentSpace.getLocation().getYLocation() < 5)
        {
            APUsed = 2;
        }
        else
        {
            APUsed = 1;
        }
        return APUsed;
	}

	public Developer checkHighestDeveloper(Location location) {
		return null;

	}

    public void selectDeveloper(String color) throws Exception
    {
        if(board.getCurrentSpace().hasDeveloper())
        {
            if(board.getCurrentSpace().getDeveloper().getColor() == color) {
                currentDeveloper = board.getCurrentSpace().getDeveloper();
                currentDevLocation = board.getCurrentSpace().getLocation();
            }
            else
            {
                throw new WrongDeveloperColorException();
            }
        }
        else
        {
            throw new NoDeveloperOnSpaceException();
        }
    }

    public void deselectDeveloper()
    {
        currentDeveloper = null;
        currentDevLocation = null;
    }


	public ArrayList<Space> shortestPath() throws Exception {
        return pathFinding.getShortestPath(board.getSpace(currentDevLocation), board.getCurrentSpace());
	}
	public int shortestPathCost() {
		return pathFinding.getAPUsed();

	}

    public void rotate(){
        board.rotateClockwise();
    }

    public void undoDeveloperPlacement() {
        board.undoDeveloperPlacement();
    }
}
