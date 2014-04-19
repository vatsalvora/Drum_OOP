package model;


/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class VillageTile extends Tile {

	private Block belongsTo;
	

    public VillageTile(Block belongsTo){
    	this.belongsTo = belongsTo;
    }
	
    public Block block(){
    	return belongsTo;
    }
	
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }
    


}
