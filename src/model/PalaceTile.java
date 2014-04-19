package model;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by jose
 */
public class PalaceTile extends Tile {


	private Location location;
	private int possition;
	

    public PalaceTile(int possition){
    	this.possition = possition ;
    }


	@Override
	public void assignPossition(int possiton) {

		this.possition = possiton;
	}

	public int getPossition(){
		return possition;
	}
	
	
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }
    
    @Override
	public void updateLocation(Location loc) {
		location = loc;
		
	}



}
