package model;


import model.customExceptions.SameBlockException;

import java.awt.*;

public abstract class Tile {
	


	public abstract boolean compareTo(Tile t);
    public abstract Color getColor();
    public abstract void assignNumberOfNeighbors(int numberOfNeighbors);
    public abstract void initNeighbors();
    public abstract int[] getNeighborsIndex();
    public abstract void createReff(Tile tile, int index);
    public abstract Tile getNeighborAt(int index);
    public abstract void removeReff(int index);
    public abstract void assignColor(int a ,int b,int c);
    public abstract Tile getReferences(int i);
    public abstract void compareNeighbors(int[] indexes) throws SameBlockException;


}
