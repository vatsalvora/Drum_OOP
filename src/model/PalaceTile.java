package model;

import model.customExceptions.SameBlockException;

import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by jose
 */
public class PalaceTile extends Tile{


    private Color color;
    private int lvl;


    public PalaceTile(int lvl) {
        this.lvl = lvl;
        assignColor(218, 165, 32);
    }





    public void assignColor(int a, int b, int c) {
        color = Color.YELLOW;
    }

    @Override
    public Tile getReferences(int i) {
        return null;
    }

    @Override
    public boolean compareTo(Tile t) {
        return false;
    }

    public int getLvl(){
        return lvl;
    }

    public Color getColor() {
        return color;
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
        int[] indexes = tile.getNeighborsIndex();
        boolean check = true;

        for (int i : indexes) {
            check = compareTo(tile.getNeighborAt(i));
        }


     }

    public String toString() {
        String tile = "PalaceTile with lvl: "+ lvl;
        return tile;
    }


}
