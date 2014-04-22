package model;


import model.customExceptions.SameBlockException;

import java.awt.*;

public abstract class Tile {
	


    public Color[] color;
	public abstract boolean compareTo(Tile t);
    public abstract Color[] getColor();
    public abstract void assignNumberOfNeighbors(int numberOfNeighbors);
    public abstract void initNeighbors();
    public abstract int[] getNeighborsIndex();
    public abstract void createReff(Tile tile, int index);
    public abstract Tile getNeighborAt(int index);
    public abstract void removeReff(int index);
    public abstract void assignColor(Color c);
    public abstract Tile getReferences(int i);
    public abstract void compareNeighbors(Tile tile) throws SameBlockException;


}
