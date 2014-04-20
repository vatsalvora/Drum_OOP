package model;

import model.customExceptions.SameBlockException;

import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by jose
 */
public class PalaceTile extends Tile {


    private Color color;
    private final Tile[] neighbors = new Tile[6];
    private int numberOfNeighbors;


    public PalaceTile(int numberOfNeighbors){

        assignColor(218,165,32);
        initNeighbors();
        assignNumberOfNeighbors(numberOfNeighbors);
    }

    public void assignNumberOfNeighbors(int numberOfNeighbors){
        this.numberOfNeighbors = numberOfNeighbors;
    }

    public void initNeighbors(){

        for(int i = 0; i < neighbors.length; i++)
            neighbors[i] = null;
    }

    public Tile getReferences(int i){
        return neighbors[i];
    }


    public int[] getNeighborsIndex(){
        int[] temp = new int[numberOfNeighbors];

        for(int i = 0, j = 0; i < neighbors.length; i++)
            if(hasNeighborAt(i))
                temp[j++] = i;

        return temp;
    }

    private boolean hasNeighborAt(int index){
        return (neighbors[index] != null)? true: false;
    }

    public Tile getNeighborAt(int index){
        return neighbors[index];
    }

    public void createReff(Tile tile, int index){
        neighbors[index] = tile;
    }

    public void removeReff(int index){
        neighbors[index] = null;
    }

    public void assignColor(int a ,int b,int c){
        color = new Color(a,b,c);
    }

    public Color getColor(){
        return color;
    }

    public boolean compareTo(Tile t) {

        return (t instanceof PalaceTile);
    }

    public void compareNeighbors(int[] indexes) throws SameBlockException {
        boolean check = false;

        for(int i : indexes)
            if(hasNeighborAt(i))
                check = true;
            else
                check = false;

        if(check)
            throw new SameBlockException("Cannot place " + (numberOfNeighbors+1) + "block on top of a" + (numberOfNeighbors+1));
    }

    public String toString(){
        String tile= "PalaceTile with: ";
        int[] neigh = getNeighborsIndex();
        for(int i = 0; i < numberOfNeighbors; i++)
            tile += neigh[i] + "\t";
        return tile;
    }


}
