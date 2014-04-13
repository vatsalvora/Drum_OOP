package model;

import java.util.LinkedList;
import java.util.List;

public class Board {
	private List<List<Space>> board;

	public Board() {
		int[] height = { 2, 3 };
		board = new LinkedList<List<Space>>();
		for (int p = 0; p < height.length; p++) {
			int n = height[p];
			List<Space> column = new LinkedList<Space>();
			for (int i = 0; i < n; i++) {
				Location location = new Location(p, i);
				Space space = new Space(location);
				column.add(space);
			}
			board.add(column);
		}
	}

	public Space getSpace(Location location) {
		List<Space> column = board.get(location.getXLocation());
		return column.get(location.getYLocation());
	}

}
