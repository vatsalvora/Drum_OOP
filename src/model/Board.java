package model;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private List<List<Space>> board;
    private Location current;
    private int width;

    public Board() {

        board = new LinkedList<List<Space>>();
        this.current = new Location(0, 0);
        initBoard();
        setNeighbors();
    }

    private void initBoard() {

        int[] height = {4, 5, 8, 10, 10, 10, 10, 9, 9, 9, 9, 11, 11, 10, 9, 9, 7, 6, 4};
        int[] gap = {2, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 2};
        width = height.length;
        for (int p = 0; p < height.length; p++) {
            int n = height[p];
            List<Space> column = new LinkedList<Space>();
            for (int i = 0; i < n; i++) {
                Location location = new Location(p, i + gap[p]);
                Space space = new HexSpace(location);
                column.add(space);

            }
            board.add(column);
        }
    }

    public int getWidth() {
        return width;
    }

    private void setNeighbors() {
        int[] gap = {1, 0, 1, -1, 0, 0, 1, -1, 0, 0, 1, -1, 0, 0, 1, -1, 0, -1, 0};
        for (int q = 0; q < board.size(); q++) {
            List<Space> list = board.get(q);
            int t = list.size();
            for (int w = 0; w < t; w++) {
                Space s = list.get(w);

                int[] col;
                int[] row;
                if (q % 2 == 0) {
                    col = new int[]{-1, 0, 1, -1, 0, 1};
                    row = new int[]{0, 1, gap[q], -1, -1, -1 + gap[q]};
                } else {
                    col = new int[]{-1, 0, 1, -1, 0, 1};
                    row = new int[]{1, 1, 1 + gap[q], 0, -1, gap[q]};
                }
                System.out.println("Col: " + q + " Row: " + w);
                for (int c = 0; c < col.length; c++) {
                    if ((q + col[c]) >= 0 && (q + col[c]) < board.size()) {
                        List<Space> neighborList = board.get(q + col[c]);
                        if ((w + row[c]) >= 0 && (w + row[c]) < neighborList.size()) {
                            s.setNeighbors(c, neighborList.get(w + row[c]));
                            System.out.println("Num: " + c + " Col: " + (q + col[c]) + " Row: " + (w + row[c]));

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

    public int getLength(int y) {
        return board.get(y).size();
    }


    public void place(Location l, Tile tile) {
        HexSpace s = (HexSpace) getSpace(l);
        s.place(tile);
    }


    public void setCurrentLocation(int x, int y) {
        current.setLocation(x, y);
    }

    public Location getCurrentLocation() {
        return current;
    }

}
