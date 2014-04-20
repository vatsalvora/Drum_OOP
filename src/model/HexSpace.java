package model;

import model.customExceptions.DevOnSpaceException;
import model.customExceptions.SpaceNotOnEdgeException;
import model.customExceptions.TileHeightWrongException;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class HexSpace implements Space {

    private Space[] neighbors;
    private Location l;
    private Stack<Tile> tilesOnSpace;
    private Developer developer;
    public Color BROWN = new Color(205,133,63);

    public HexSpace(Location l) {
        this.l = l;
        this.neighbors = new Space[6];
        tilesOnSpace = new Stack<Tile>();
        developer = null;
    }

    public Developer getDeveloper() {
        return developer;

    }

    public void placeDeveloper(Developer d) throws DevOnSpaceException {
        if (developer == null) {
            developer = d;
        } else {
            throw new DevOnSpaceException();
        }
    }

    public void removeDeveloper() {
        developer = null;
    }

    public boolean hasDeveloper() {
        return (developer != null);
    }

    public int getHeight() {
        return tilesOnSpace.size();
    }

    public Tile getTopTile() {
        return tilesOnSpace.peek();
    }

    public Tile removeTopTile() {
        return tilesOnSpace.pop();
    }

    public void addTile(Tile tile) {
        tilesOnSpace.push(tile);
    }

    public boolean spaceEmpty(){
        return tilesOnSpace.empty();
    }

    public boolean onBorder() {
        return(numberOfNeighbors() < 6);
    }

    public boolean onEdge()
    {
        boolean ret = false;
        for(Space s : neighbors)
        {
            if(s != null) {
                HexSpace h = (HexSpace) s;
                if (h.numberOfNeighbors() != 6) {
                    ret = true;
                }
            }
        }
        return ret;
    }

    public int numberOfNeighbors() {

        int number = 0;

        for (Space neighbor : neighbors) {
            if (neighbor != null)
                number++;
        }

        return number;
    }

    public Space getNeighbor(int index) {
        if (index < neighbors.length && index >= 0) return neighbors[index];
        return null;
    }

    public Space getCurrentSpace(){
        return this;
    }

    public Location getNeighborLocation(int index) {
        if (index < neighbors.length && index >= 0) return neighbors[index].getLocation();
        return null;
    }


    public Color getColor() {
        if(onBorder()){
            return BROWN;
        }
        else if (getHeight() == 0) {
            return new Color(239, 221, 111);
        } else {
            Tile s = tilesOnSpace.peek();
            return s.getColor();
        }
    }

    public void place(Tile tile) {


        try {

         int[] neighLocations = tile.getNeighborsIndex();
            if(!spaceEmpty())
                getTopTile().compareNeighbors(neighLocations);
           //checkingOutSideJava(tile);
            tilesOnSpace.add(tile);

            System.out.println(this);
        } catch (Exception e) {

            System.out.println(e);
            //removeTopTile();
            //tell user what went wrong with tile placement
        }
    }

    public void checkingOutSideJava(Tile tile) throws SpaceNotOnEdgeException {

        boolean checking = true;

        for(int a : tile.getNeighborsIndex()) {
            checking = ((HexSpace) getNeighbor(a)).onBorder();

            System.out.println("checking: " + checking);

            if(!checking)
                break;
        }

        checking = getCurrentSpace().onBorder();

        if(checking )
        throw new SpaceNotOnEdgeException("Cannot place all tiles outside java!");
    }

    public void checkHeights(Tile tile) throws TileHeightWrongException {

        Set<Integer> heights = new HashSet<Integer>();

        heights.add(getHeight());

        int length = tile.getNeighborsIndex().length;

        for(int a : tile.getNeighborsIndex())
            heights.add(((HexSpace) getNeighbor(a)).getHeight());

        if (heights.size() != 1 &&  length != 0 )
            throw new TileHeightWrongException("Tile heights are inconsistent in the area the block is being placed.");

    }

    public void updateNeighbor(Space s, Tile t){
        ((HexSpace)s).place(t);
    }

    public void setNeighbors(int index, Space s) {
        neighbors[index] = s;
    }

    public Location getLocation() {
        return l;
    }

    public Space[] getNeighbors() {
        return neighbors;
    }

    public String toString(){
        String space = "Tile on Space: " + getTopTile() +" neighbors"+ "the heigh is: " + getHeight() +"\n";


        return space;
    }
}
