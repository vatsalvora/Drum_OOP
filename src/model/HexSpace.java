package model;

import java.awt.*;

public class HexSpace implements Space{
	
	private Space[] neighbors;
	private Location l;
    public int status;
    public Color color;
    
    
	public HexSpace(Location l) {
		this.l = l;
		this.neighbors = new Space[6];
        this.status = 0;
        this.color = Color.BLUE;
	}

	public Developer getDeveloper() {
		return null;

	}

	public void removeDeveloper() {

	}

	public int getHeight() {
		return 0;

	}

	public Tile getTopTile() {
		return null;

	}

	public boolean onBoarder() {
		return (numberOfNeighbors() != 6) ? true:false;

	}
	
	private int numberOfNeighbors(){
		
		int number = 0;
		
		for(int i = 0; i < neighbors.length; i++){
			if(neighbors[i] != null)
				number++;
		}
			
		
		return number;
	}

	public Space[] getNeighbors() {
		return neighbors;

	}

    public void setNeighbors(int index, Space s){
        neighbors[index] = s;
    }

    public Location getLocation(){
        return l;
    }

}
