package model;

import java.util.Stack;

/**
 * Created by Vatsal on 4/13/2014.
 */
public class PalaceTile extends Tile{


    public PalaceTile(){

    }


    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateCounterclockwise() {

    }

    @Override
    public boolean compareTo(Tile t) {
        return (t instanceof PalaceTile);
    }


}
