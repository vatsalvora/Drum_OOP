package model;


import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class VillageTile extends Tile {

    private Color color;

	

    public VillageTile(){
        this.color = new Color(214,166,81);
    }
	
    public Color getColor(){
        return color;
    }
	
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }
    


}
