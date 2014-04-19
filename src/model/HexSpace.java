package model;

import java.awt.*;
import java.util.Stack;

public class HexSpace implements Space {

	private Space[] neighbors;
	private Location l;
	public Color color;
	private Stack<Tile> tilesOnSpace;

	public HexSpace(Location l) {
		this.l = l;
		this.neighbors = new Space[6];
		this.color = Color.ORANGE;
		tilesOnSpace = new Stack<Tile>();
	}

	public Developer getDeveloper() {
		return null;

	}

	public void removeDeveloper() {
		tilesOnSpace.pop();
	}
	

	public void removeTile(){
		
	}
	
	public int getHeight() {
		return tilesOnSpace.size();
	}

	public Tile getTopTile() {
		return tilesOnSpace.peek();
	}

    public Tile removeTopTile()
    {
        return tilesOnSpace.pop();
    }

	public void addTile(Tile tile) {
		tilesOnSpace.push(tile);
	}

	public boolean onBoarder() {
		return (numberOfNeighbors() != 6);

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
        if(index<neighbors.length && index >=0) return neighbors[index];
		return null;
	}
	
	public Location getNeighborLocation(int index) {
        if(index<neighbors.length && index >=0) return neighbors[index].getLocation();
		return null;
	}


    public void place(Tile tile) {
        if(tilesOnSpace.size()==0){
            tilesOnSpace.add(tile);
        }
        else{
            Tile under = tilesOnSpace.peek();
//            under.place(tile,tilesOnSpace);
        }
    }

    public void setNeighbors(int index, Space s) {
        neighbors[index] = s;
    }

    public Location getLocation() {
        return l;
    }

    public Space[] getNeighbors()
    {
        return neighbors;
    }
}
