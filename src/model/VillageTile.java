package model;


/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class VillageTile extends Tile {

	private int possition;

    public VillageTile(){
    	possition = 0;
    }


	@Override
	public void assignPossition(int possiton) {

		this.possition = possiton;
	}

	public int getPossition(){
		return possition;
	}
	
	@Override
	public void rotateClockwise() {
		
		if(possition == 6)
			possition = 1;
		else
			possition++;
		
	}

	@Override
	public void rotateCounterclockwise() {
		if(possition == 1)
			possition = 6;
		else
			possition--;
		
	}
	
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }

}
