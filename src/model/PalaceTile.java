package model;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by jose
 */
public class PalaceTile extends Tile {


	private Location location;
	private int position;
	

    public PalaceTile(int position){
    	this.position = position ;
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
    

	public void updateLocation(Location loc) {
		location = loc;
		
	}



}
