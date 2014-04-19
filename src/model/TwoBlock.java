package model;

/*I created this class because Tile was had some illegal behaviors such as rotating. */


public class TwoBlock extends Block{

	Location center;
	Tile centerType;
	Tile[] neighbors;
	
	TwoBlock(Space loc){
		initNeighbors();
		setCenter(loc);
		assignCenterType();
		assignNeighbors(1);
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
		neighbors= new Tile[2];
		
		for(int i = 0; i < neighbors.length; i++){
			neighbors[i] = null;
		}
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
		
	}

}
