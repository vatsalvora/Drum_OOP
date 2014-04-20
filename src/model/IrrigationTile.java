package model;


import java.awt.*;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class IrrigationTile extends Tile {

	private int position;
    private Color color;
	

    public IrrigationTile(){
    	this.position = position ;
        this.color = Color.BLUE;
    }

    public Color getColor(){
        return color;
    }

	public void assignPosition(int position) {

		this.position = position;
	}

	public int getPosition(){
		return position;
	}
	
	
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }
    



}
