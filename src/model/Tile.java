package model;

import java.util.Stack;

public abstract class Tile {

	 protected int[] neighbors = new int[2];
	 
	public abstract void rotateClockwise();

	public abstract void rotateCounterclockwise();

	public abstract boolean equals(Object t);


	public int[] getNeighborsLocations() {
		// TODO Auto-generated method stub
		return neighbors;
	}

}
