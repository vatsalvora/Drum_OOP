package model;


import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class RiceTile extends Tile{
 
    private Color color;



    public RiceTile(){
    	color = Color.GREEN;
    }


    public Color getColor(){
        return color;
    }
	
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }

}
