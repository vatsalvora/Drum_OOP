package model;

import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by jose
 */
public class PalaceTile extends Tile {


	private Color color;
	private int position;
	

    public PalaceTile(int position){
    	this.position = position ;
        this.color = new Color(218,165,32);
    }


    public Color getColor(){
        return color;
    }

	public void assignPosition(int positon) {

		this.position = positon;
	}

	public int getPosition(){
		return position;
	}
	
	
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }
    




}
