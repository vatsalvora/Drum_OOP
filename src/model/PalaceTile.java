package model;

import model.customExceptions.SameBlockException;

import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by jose
 */
public class PalaceTile extends Tile{


    private Color palace;
    private int lvl;



    public PalaceTile(int lvl) {
        this.lvl = lvl;
        palace = Color.YELLOW;
        assignColor(Color.BLACK);
    }

    @Override
    public int getNumberOfRefs() {
        return 0;
    }

    @Override
    public Tile getReferences(int i) {
        return null;
    }

    @Override
    public boolean compareTo(Tile t) {
        return t instanceof PalaceTile;
    }

    public int getLvl(){
        return lvl;
    }


    @Override
    public void assignNumberOfNeighbors(int numberOfNeighbors) {

    }

    @Override
    public void initNeighbors() {

    }

    @Override
    public int[] getNeighborsIndex() {
        return new int[0];
    }

    @Override
    public void createReff(Tile tile, int index) {

    }
    public void assignColor(Color c){

        color = new Color[]{palace, palace, c};
    }

    public Color[] getColor(){
        return color;
    }

    @Override
    public Tile getNeighborAt(int index) {
        return null;
    }

    @Override
    public void removeReff(int index) {

    }

    public boolean compareTo(Object o) {

        return (o instanceof PalaceTile);
    }


    public void compareNeighbors(Tile tile) throws SameBlockException {

            if(!compareTo(tile))
            throw new SameBlockException("cannot place anything on top of a palace");


     }

    public String toString() {
        String tile = "PalaceTile with lvl: "+ lvl;
        return tile;
    }


}
