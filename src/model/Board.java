package model;

import java.util.LinkedList;
import java.util.List;

public class Board {
	private List<List<Space>> board;

	public Board() {

		board = new LinkedList<List<Space>>();
		initBoard();
		setNeighbors();
	}
	
	private void initBoard(){
		
		int[] height = { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
		
		for (int p = 0; p < height.length; p++) {
			int n = height[p];
			List<Space> column = new LinkedList<Space>();
			for (int i = 0; i < n; i++) {
				Location location = new Location(p, i);
				Space space = new HexSpace(location);
				column.add(space);

			}
			board.add(column);
		}
	}
	private void setNeighbors(){
		 for(int q = 0; q< board.size(); q++)
	        {
	            List<Space> list = board.get(q);
	            int t = list.size();
	            for(int w=0; w< t; w++)
	            {
	                Space s = list.get(w);
	                int[] col = new int[6];
	                int[] row = new int[6];
	                if(w%2==0){
	                    row = new int[]{-1,0,1,-1,0,1};
	                    col = new int[]{0,1,0,-1,-1,-1};
	                }
	                else
	                {
	                    row = new int[]{-1,0,1,-1,0,1};
	                    col = new int[]{1,1,1,0,-1,0};
	                }

	                for(int c=0; c<col.length; c++)
	                {
	                        if((q+col[c])>=0 && (q+col[c])<board.size()){
	                            List<Space> neighborList = board.get(q+col[c]);
	                            if((w+row[c])>=0 && (w+row[c])<neighborList.size()){
	                                s.setNeighbors(c,neighborList.get(w+row[c]));
	                            }
	                        }
	                }
	            }
	        }
	}
	
	public Space getSpace(Location l) {
		List<Space> column = board.get(l.getYLocation());
		return column.get(l.getXLocation());
	}
	

}
