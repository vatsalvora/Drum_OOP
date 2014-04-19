package model;

import java.util.Stack;

/**
 * Created by Vatsal on 4/13/2014.
 */
public class VillageTile extends Tile {
    private Tile[] neighbors;

    public VillageTile(int numNeighbors){
        this.neighbors = new Tile[numNeighbors];
    }
    @Override
    public Tile[] getNeighbors() {
        return neighbors;
    }

    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateCounterclockwise() {

    }

    @Override
    public boolean equals(Object t) {
        return (t instanceof VillageTile);
    }

    @Override
    public void place(Tile t, Stack<Tile> tilesOnSpace) {
        if(!equals(t)) tilesOnSpace.push(t);
    }
}
