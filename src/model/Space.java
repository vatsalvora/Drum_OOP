package model;

import java.awt.*;
import java.util.Stack;

public class Space {
	private Space[] neighbors;
    private Stack<Tile> tileStack;
	private Location l;
    public int status;
    public Color color;
	public Space(Location l) {
		this.l = l;
		this.neighbors = new Space[6];
        this.status = 0;
        this.color = Color.BLUE;
        this.tileStack = new Stack<Tile>();
	}

	public Developer getDeveloper() {
		return null;

	}

	public void removeDeveloper() {

	}

	public int getHeight() {
		return 0;

	}

	public Tile getTopTile() {
		return null;

	}

	public boolean onBoarder() {
		return false;

	}

	public Space[] getNeighbors() {
		return neighbors;

	}

    public void setNeighbors(int index, Space s){
        neighbors[index] = s;
    }

    public Location getLocation(){
        return l;
    }

    public void place(Tile tile) {
        if(tileStack.size()==0){
            tileStack.add(tile);
        }
        else{
            Tile under = tileStack.peek();
            under.place(tile);
        }
    }
}
