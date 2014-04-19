package model;


/*We created Space because the board doesn't need to know what type of space is going to be using and if we want to use another space it will be perfectly fine
*/
public interface Space {

		public boolean onBoarder();

	    public void setNeighbors(int index, Space s);

    public Space[] getNeighbors();

    public Tile getTopTile();

	    public Location getLocation();
	    
	    

}
