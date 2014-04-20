package model;

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
    




}
