package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Board {
	private List<List<Space>> board;

	public Board() {
        int[] height = {12,12,12,12,12,12,12,12,12,12,12,12};
		board = new LinkedList<List<Space>>();
		for (int p = 0; p < height.length; p++) {
			int n = height[p];
			List<Space> col = new LinkedList<Space>();
			for (int i = 0; i < n; i++) {
				Location l = new Location(i, p);
				Space s = new Space(l);
				col.add(s);
			}
			board.add(col);
		}
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
                        if((q+col[c])>0 && (q+col[c])<board.size()){
                            List<Space> neighborList = board.get(q+col[c]);
                            if((w+row[c])>0 && (w+row[c])<neighborList.size()){
                                s.setNeighbors(c,neighborList.get(w+row[c]));
                            }
                        }
                }
            }
        }
	}

	public Space getSpace(Location l) {
		List<Space> col = board.get(l.getYLocation());
		return col.get(l.getXLocation());
	}

}
