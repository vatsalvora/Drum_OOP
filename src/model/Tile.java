package model;


public abstract class Tile {

	public abstract boolean compareTo(Tile t);
	public abstract void assignPossition(int possiton);
	public abstract void rotateClockwise();
	public abstract void rotateCounterclockwise();

}
