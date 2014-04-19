package model;

/*I created this class because Tile was had some illegal behaviors such as rotating. */


public class TwoBlock extends Block{

	Location center;
	Tile centerType;
	Tile[] neighbors;
	final private int numberOfNeighbors = 1;
	
	TwoBlock(){
		initNeighbors();
		assignCenterType();
		assignNeighbors(numberOfNeighbors);
	}

	
	private void assignNeighbors(int numberOfNeighbors){
    	for(int i = 0; i < numberOfNeighbors; i++){
    			neighbors[i] = new RiceTile();
    			neighbors[i].assignPossition(i+1);
    	}
    }
	
	private void setCenter(Space loc) {
		center = loc.getLocation();
		
	}
	
	private void assignCenterType(){
		centerType = new VillageTile();
	}
	
	private void initNeighbors(){
		neighbors= new Tile[numberOfNeighbors];
		
		for(int i = 0; i < neighbors.length; i++){
			neighbors[i] = null;
		}
	}
	
	public int[] getNeighborsPossition(){
		int[] possitions = new int[numberOfNeighbors];
		
		for(int i = 0 ; i < numberOfNeighbors; i++)
				possitions[i] = neighbors[i].getPossition();
		
		return possitions;
	}
	
	@Override
	public void rotateClockwise() {
		
    	for(int i = 0 ; i < neighbors.length; i++)
    			neighbors[i].rotateClockwise();
    			
    	
    }

	@Override
    public void rotateCounterclockwise() {
    	
		for(int i = 0 ; i < neighbors.length; i++)
    				neighbors[i].rotateCounterclockwise();

    }

	@Override
	public boolean compareTo(Block block) {
		// TODO Auto-generated method stub
		return block instanceof TwoBlock;
	}

	@Override
	public void placeOn(Space loc) {
		setCenter(loc);
	}

}
