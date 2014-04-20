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

    private void assignNumberOfNeighbors(int numberOfNeighbors){
        this.numberOfNeighbors = numberOfNeighbors;
    }

    private void initNeighbors(){

        for(int i = 0; i < neighbors.length; i++)
            neighbors[i] = null;
    }

    protected void createReff(Tile tile, int index){
        neighbors[index] = tile;
    }

    protected void removeReff(int index){
        neighbors[index] = null;
    }

    private void assignColor(int a ,int b,int c){
        color = new Color(a,b,c);
    }

    public Color getColor(){
        return color;
    }

    public boolean compareTo(Tile t) {

        return (t instanceof IrrigationTile);
    }




}
