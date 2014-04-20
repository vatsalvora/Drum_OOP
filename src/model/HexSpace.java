package model;

import model.customExceptions.DevOnSpaceException;
import model.customExceptions.TileHeightWrongException;

import java.awt.*;
import java.util.Stack;

public class HexSpace implements Space {

	private Space[] neighbors;
	private Location l;
	private Stack<Tile> tilesOnSpace;
    private Developer developer;

	public HexSpace(Location l) {
		this.l = l;
		this.neighbors = new Space[6];
		tilesOnSpace = new Stack<Tile>();
        developer = null;
	}

	public Developer getDeveloper() {
		return developer;

	}

    public void placeDeveloper(Developer d) throws DevOnSpaceException
    {
        if(developer == null)
        {
            developer = d;
        }
        else
        {
            throw new DevOnSpaceException();
        }
    }

	public void removeDeveloper() {
        developer = null;
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


    public Color getColor(){
        if(getHeight()==0){
            return new Color(239, 221, 111);
        }
        else{
            Tile s = tilesOnSpace.peek();
            return s.getColor();
        }
    }

    public void place(Tile tile) {
        if(tilesOnSpace.size()==0){
            tilesOnSpace.add(tile);
            try {
                //check tile's connections and place connected tiles down as well, throwing exception if error occurs
            }
            catch(Exception e)
            {
                tilesOnSpace.pop();
                //tell user what went wrong with tile placement
            }
        }
        else{
            Tile under = tilesOnSpace.peek();
//            under.place(tile,tilesOnSpace);
            //check tile's connections and place connected tiles down as well, throwing exception if error occurs
        }
    }

    public void place(Tile tile, int height) throws TileHeightWrongException
    {
        if(tilesOnSpace.size()==height){
            if(height == 0) {
                tilesOnSpace.add(tile);
            }
            else
            {
                Tile under = tilesOnSpace.peek();
//              under.place(tile,tilesOnSpace);
            }
        }
        else{
            throw new TileHeightWrongException();
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
