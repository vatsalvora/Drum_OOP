package model;

import model.customExceptions.DevOnSpaceException;
import model.customExceptions.NoDevsOnBoardException;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {

    private List<List<Space>> board;
    private HexSpace current;
    private int width;
    private int size;
    private int[] rotations;
    private List<Space> developerLocs;

    public Board() {
        developerLocs = new ArrayList<Space>();
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
    public void addDeveloperLoc(Space s){developerLocs.add(s);}
    public void removeDeveloperLoc(Space s){developerLocs.remove(s);}
    public void getNextDeveloper(Color color) throws NoDevsOnBoardException {
        System.out.println(developerLocs.size());
        int i = 0;
        boolean found = false;
        if(current.getColor()[1].equals(color)) {
            for (int s = 0; s < developerLocs.size(); s++) {
                if (developerLocs.get(s).equals(current)){
                    i = s;
                    found = true;
                }
            }
            boolean foundNext = false;
            if(found){
                for(int q = i+1; q<developerLocs.size(); q++){
                    if(((HexSpace)developerLocs.get(q)).getDeveloper().getViewColor().equals(color)){
                        foundNext = true;
                        current = (HexSpace)developerLocs.get(q);
                    }
                }
                if(!foundNext){
                    for(int z=0; z<i; z++){
                        if(((HexSpace)developerLocs.get(z)).getDeveloper().getViewColor().equals(color)){
                            foundNext = true;
                            current = (HexSpace)developerLocs.get(z);
                        }
                    }
                    System.out.println(foundNext);
                    if(!foundNext){
                        throw new NoDevsOnBoardException();
                    }
                }
            }

        }
        else{
            for(Space s : developerLocs){
                if(((HexSpace)s).getDeveloper().getViewColor().equals(color)){
                    found = true;
                    current = (HexSpace)s;
                }
            }
            if(!found){
                throw new NoDevsOnBoardException();
            }
        }
    }
    public void resetCurrent(){
        current = (HexSpace)getSpace(new Location(0, 0));
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


    public void place(Tile tile) throws Exception {
        if(tile.getNumberOfRefs()>0)current.checkHeights(tile);

            current.place(tile);
            try {
            for (int i = 0; i < 6; i++) {
                Tile t = tile.getReferences(i);
                if (t != null) {
                    HexSpace s = (HexSpace) (current.getNeighbor(i));
                    s.place(t);
                }
            }
        }
            catch(Exception e)
            {
                current.removeTopTile();
                for(int i = 0; i < 6; i++)
                {
                    Tile t = tile.getReferences(i);
                    if(t != null)
                    {
                        HexSpace s = (HexSpace) (current.getNeighbor(i));
                        if(t == s.getTopTile())
                        {
                            s.removeTopTile();
                        }
                    }
                }
                throw e;
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
