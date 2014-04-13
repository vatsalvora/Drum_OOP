package model;

public abstract class Tile {

	public abstract void rotateClockwise();

	public abstract void rotateCounterclockwise();

	public abstract boolean compareTo(Tile t);

	public abstract void place(Tile t);

	public Tile[] getNeighbors() {
		// TODO Auto-generated method stub
		return null;
	}

}
