package model;


import model.customExceptions.SameBlockException;

import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class IrrigationTile extends Tile {

    private final Tile[] neighbors = new Tile[6];
    private int numberOfNeighbors;
    private boolean scored;


    public IrrigationTile(int numberOfNeighbors){
        scored = false;
        assignColor(Color.BLACK);
        initNeighbors();
        assignNumberOfNeighbors(numberOfNeighbors);
    }
    public boolean getScored(){return scored;}
    public void setScored(boolean b){scored = b;};
    public Tile getReferences(int i){
        return neighbors[i];
    }
    public void assignNumberOfNeighbors(int numberOfNeighbors){
        this.numberOfNeighbors = numberOfNeighbors;
    }

    public int[] getNeighborsIndex(){
        int[] temp = new int[numberOfNeighbors];

        for(int i = 0, j = 0; i < neighbors.length; i++)
            if(hasNeighborAt(i))
                temp[j++] = i;

        return temp;
    }

    public void assignColor(Color c){

        color = new Color[]{Color.BLUE, Color.BLUE, c};
    }

    public Color[] getColor(){
        return color;
    }

    private boolean hasNeighborAt(int index){
        return (neighbors[index] != null);
    }

    public Tile getNeighborAt(int index){
        return neighbors[index];
    }

    public void initNeighbors(){

        for(int i = 0; i < neighbors.length; i++)
            neighbors[i] = null;
    }

    public void createReff(Tile tile, int index){
        neighbors[index] = tile;
    }

    public void removeReff(int index){
        neighbors[index] = null;
    }



    public boolean compareTo(Tile t) {

        return (t instanceof IrrigationTile);
    }

    public void sameNeighbors(Tile tile){
        if(tile.getNeighborsIndex().length == getNeighborsIndex().length){

        }
            //throw exception here
    }

    public void compareNeighbors(Tile tile) throws SameBlockException {
        int[] indexes = tile.getNeighborsIndex();
        boolean check = false;

        for(int i : indexes)
            if(hasNeighborAt(i))
                check = true;
            else
                check = false;

        if(check)
            throw new SameBlockException("Cannot place " + (numberOfNeighbors+1) + "block on top of a" + (numberOfNeighbors+1));
    }

    @Override
    public int getNumberOfRefs() {
        return 0;
    }

    public String toString(){
        String tile= "IrrigationTile with: ";
        int[] neigh = getNeighborsIndex();
        for(int i = 0; i < numberOfNeighbors; i++)
            tile += neigh[i] + "\t";
        return tile;
    }

}
