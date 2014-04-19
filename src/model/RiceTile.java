package model;


/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class RiceTile extends Tile{
 

	private int possition;

    public RiceTile(){
    	possition = 0;
    }

     
    public boolean compareTo(Tile t) {

        return (t instanceof VillageTile);
    }

	@Override
	public void assignPossition(int possiton) {

		this.possition = possiton;
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

}
