package model;

/**
 * Created by Vatsal on 4/13/2014.
 * edited by jose
 */
public class PalaceTile extends Tile {


	private int possition;


    public PalaceTile(){
    	possition = 0;
    }
     
    public boolean compareTo(Tile t) {
        return (t instanceof VillageTile);
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




}
