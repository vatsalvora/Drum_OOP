package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Board {
	private List<List<Space>> board;

	public Board() {
        int[] height = {2,3};
		board = new LinkedList<List<Space>>();
		for (int p = 0; p < height.length; p++) {
			int n = height[p];
			List<Space> col = new LinkedList<Space>();
			for (int i = 0; i < n; i++) {
				Location l = new Location(p, i);
				Space s = new Space(l);
				col.add(s);
			}
			board.add(col);
		}
	}

	public Space getSpace(Location l) {
		List<Space> col = board.get(l.getXLocation());
		return col.get(l.getYLocation());
	}

}
