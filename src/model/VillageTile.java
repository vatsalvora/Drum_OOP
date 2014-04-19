package model;


/**
 * Created by Vatsal on 4/13/2014.
 * edited by Jose
 */
public class VillageTile extends Tile {
   

    public VillageTile(int numberOfNeighbors){
        assignNeighbors(numberOfNeighbors); 
    }
    

    private void assignNeighbors(int numberOfNeighbors){
    	for(int i = 0; i < numberOfNeighbors; i++)
    			neighbors[0] = i+1;
    }
    
    public int[] getNeighborsLocations() {
        return neighbors;
    }

 
    public void rotateClockwise() {
    	for(int i = 0 ; i < neighbors.length; i++)
    		if(neighbors[i] != 0)
    			if(neighbors[i] != 6)
    				neighbors[i] = i+1;
    			else
    				neighbors[i] = 1;
    	
    }


    public void rotateCounterclockwise() {
    	for(int i = 0 ; i < neighbors.length; i++)
    		if(neighbors[i] != 0)
    			if(neighbors[i] != 1)
    				neighbors[i] = i-1;
    			else
    				neighbors[i] = 6;
    }

 
    public boolean equals(Object t) {
        return (t instanceof VillageTile);
    }


}
