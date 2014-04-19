package model;

/**
 * Created by Vatsal on 4/13/2014.
 */
public class PalaceTile extends Tile {


    public PalaceTile() {

    }


    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateCounterclockwise() {

    }

    @Override

    public boolean equals(Object t) {
        //TODO It is an equals method, not a method to check the instance of... Should include .equals() or similar to that
        return (t instanceof PalaceTile);

    }

}
