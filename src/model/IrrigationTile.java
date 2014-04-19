package model;


/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class IrrigationTile extends Tile {

	private Location location;
	private int possition;
	

    public IrrigationTile(int possition){
    	this.possition = possition ;
    }



	public void assignPossition(int position) {

		this.possition = position;
	}

	public int getPossition(){
		return possition;
	}
	
	
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }
    

	public void updateLocation(Location loc) {
		location = loc;
		
	}

}
