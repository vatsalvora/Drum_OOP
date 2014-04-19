package model;

import java.util.Stack;

public abstract class Tile {

	public abstract void rotateClockwise();

	public abstract void rotateCounterclockwise();

	public abstract boolean equals(Object t);

	public abstract void place(Tile t, Stack<Tile> tilesOnSpace);

	public Tile[] getNeighbors() {
		// TODO Auto-generated method stub
		return null;
	}

}
