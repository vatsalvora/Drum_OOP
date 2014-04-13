package model;

/**
 * Created by Vatsal on 4/13/2014.
 */
public class IrrigationTile extends Tile {
    private Tile[] neighbors;

    public IrrigationTile(int numNeighbors){
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
    public boolean compareTo(Tile t) {
        return (t instanceof IrrigationTile);
    }
}
