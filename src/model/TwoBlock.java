package model;

/*I created this class because Tile was had some illegal behaviors such as rotating. */


public class TwoBlock extends Block{
	
	final protected int[] validPossitions = {1,2,3,7,8,9};
	
	Space loc;
	int[] neighborsPostion = new int[1];
	Tile centerTile;
	Tile[] neighbors;
	final private int numberOfNeighbors = 1;
	
	TwoBlock(Space loc){
		this.loc = loc;
		initNeighbors();
		assignCenterType();
		assignNeighbors(numberOfNeighbors);
	}

	
	private void assignNeighbors(int numberOfNeighbors){
		
    	for(int i = 0; i < numberOfNeighbors; i++){
    			neighbors[i] = new RiceTile(this);
    			neighborsPostion[i] = validPossitions[i];
    			HexSpace temp =  (HexSpace) ((HexSpace)loc).getNeighbor(i);
    			temp.addTile(neighbors[i]);
    			((HexSpace)loc).setNeighbors(i, temp);
    	}
    }

	
	private void assignCenterType(){
		centerTile = new VillageTile(this);
		((HexSpace)loc).addTile(centerTile);
	}
	
	private void initNeighbors(){
		neighbors= new Tile[numberOfNeighbors];
		
		for(int i = 0; i < neighbors.length; i++){
			neighbors[i] = null;
		}
	}
	
	public int[] getNeighborsPossition(){
		
		return neighborsPostion;
	}
	
	@Override
	public void rotateClockwise() {
		
		for(int i = 0; i < neighbors.length; i++)
			if(i+1 == 7)
			neighborsPostion[i] = validPossitions[0];
			else
				neighborsPostion[i] = validPossitions[i+1];	
    }

	@Override
    public void rotateCounterclockwise() {
    	
		for(int i = 0; i < neighbors.length; i++)
			if(i-1 == -1)
			neighborsPostion[i] = validPossitions[6];
			else
				neighborsPostion[i] = validPossitions[i-1];	

    }

	@Override
	public boolean compareTo(Block block) {
		// TODO Auto-generated method stub
		return block instanceof TwoBlock;
	}


	@Override
	public void placeOn(Space loc) {
		// TODO Auto-generated method stub
		
	}


}
