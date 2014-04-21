package model;

import model.customExceptions.DevOnSpaceException;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private List<List<Space>> board;
    private HexSpace current;
    private int width;
    private int size;
    private int[] rotations;

    public Board() {

        rotations = new int[0];
        board = new LinkedList<List<Space>>();
        size = 0;
        initBoard();
        setNeighbors();
        this.current = (HexSpace)getSpace(new Location(0, 0));
    }

    public void setRotations(int[] rotations){
        this.rotations = rotations;
    }

    public void undoTilePlacement() {
        Tile t = current.removeTopTile();
        for (int i = 0; i < 6; i++) {
            Tile ref = t.getReferences(i);
            if (ref != null) {
                HexSpace s = (HexSpace) (current.getNeighbor(i));
                s.removeTopTile();
            }
        }
    }

    public int[] getRotations(){
        return rotations;
    }
    private void initBoard() {

        int[] height = {5, 6, 9, 11, 11, 11, 11, 10, 10, 10, 10, 12, 12, 11, 10, 10, 8, 7, 5};
        int[] gap = {2, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 2};
        for(int i=0; i<height.length; i++) size = Math.max(size, height[i]+gap[i]);
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

    public int getMaxLen(){return size;}
    public int getWidth() {
        return width;
    }

    public HexSpace getCurrentSpace(){
        return current;
    }

    public void setCurrentSpace(HexSpace space){
        current = space;
    }

    private void setNeighbors() {
        int[] gap =    {1,0,1,-1,0,0,1,-1,0,0,1,-1,0,0,1,-1,0,-1,0};
        int[] gapLeft= {1,-1,0,-1,1,0,0,-1,1,0,0,-1,1,0,0,-1,1,0,1};
        for (int q = 0; q < board.size(); q++) {
            List<Space> list = board.get(q);
            int t = list.size();
            for (int w = 0; w < t; w++) {
                Space s = list.get(w);

                int[] col;
                int[] row;
                if (q % 2 == 0) {
                    col = new int[]{-1, 0, 1, -1, 0, 1};
                    row = new int[]{0+gapLeft[q], 1, 0+gap[q], -1+gapLeft[q], -1, -1+gap[q]};
                } else {
                    col = new int[]{-1, 0, 1, -1, 0, 1};
                    row = new int[]{1+gapLeft[q], 1, 1+gap[q], 0+gapLeft[q], -1, 0+gap[q]};
                }

                for (int c = 0; c < col.length; c++) {
                    if ((q + col[c]) >= 0 && (q + col[c]) < board.size()) {
                        List<Space> neighborList = board.get(q + col[c]);
                        if ((w + row[c]) >= 0 && (w + row[c]) < neighborList.size()) {
                            s.setNeighbors(c, neighborList.get(w + row[c]));
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


    public void place(Tile tile) {

        try {

            current.checkHeights(tile);
        }catch(Exception e){
            System.out.println(e);
            return;
        }

        current.place(tile);

        for(int i=0; i<6; i++){
            Tile t = tile.getReferences(i);
            if(t!=null) {
                HexSpace s = (HexSpace) (current.getNeighbor(i));
                s.place(t);
            }
        }

    }

    public void placeDeveloper(Developer developer) throws DevOnSpaceException {
            current.placeDeveloper(developer);
    }

    public void rotateClockwise(){

        for(int i = 0; i < rotations.length; i++) {
            rotations[i] = ((rotations[i] - 1)+6) % 6;
        }

    }


    public void undoDeveloperPlacement() {
        current.removeDeveloper();
    }
}
