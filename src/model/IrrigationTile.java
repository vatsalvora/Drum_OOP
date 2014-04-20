package model;


import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class IrrigationTile extends Tile {

    private Color color;
    private final Tile[] neighbors = new Tile[6];
    private int numberOfNeighbors;


    public IrrigationTile(int numberOfNeighbors){

        assignColor(35,62,235);
        initNeighbors();
        assignNumberOfNeighbors(numberOfNeighbors);
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

    private boolean hasNeighborAt(int index){
        return (neighbors[index] != null)? true: false;
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

    public void assignColor(int a ,int b,int c){
        color = new Color(a,b,c);
    }

    public Color getColor(){
        return color;
    }

    public boolean compareTo(Tile t) {

        return (t instanceof IrrigationTile);
    }




}
