package model;

public abstract class  Block {

	public abstract void rotateClockwise();

	public abstract void rotateCounterclockwise();

	public abstract boolean compareTo(Block B);
	
	public abstract void placeOn(Space loc);
	
}
