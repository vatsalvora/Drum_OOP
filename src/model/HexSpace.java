package model;

import model.customExceptions.DevOnSpaceException;
import model.customExceptions.OnIrrigationTile;
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
	public Color BROWN = new Color(205, 133, 63);

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

	public boolean spaceEmpty() {
		return tilesOnSpace.empty();
	}

	public boolean onBorder() {
		return (numberOfNeighbors() < 6);
	}

	public boolean onEdge() {
		boolean ret = false;
		for (Space s : neighbors) {
			if (s != null) {
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
		if (index < neighbors.length && index >= 0)
			return neighbors[index];
		return null;
	}

	public Space getCurrentSpace() {
		return this;
	}

	public Location getNeighborLocation(int index) {
		if (index < neighbors.length && index >= 0)
			return neighbors[index].getLocation();
		return null;
	}

	public Color[] getColor() {
		if (getHeight() > 0) {
			Tile s = tilesOnSpace.peek();
            Color [] c = s.getColor();
            Color [] ret = new Color[]{c[0],c[1],c[2]};
			if (hasDeveloper()) {
				ret[1] = getDeveloper().getViewColor();
			}
			return ret;
		} else if (onBorder()) {
			return new Color[] { BROWN, BROWN, Color.BLACK };
		} else {
			return new Color[] { new Color(239, 221, 111), new Color(239, 221, 111), Color.BLACK };
		}
	}

	public void place(Tile tile) throws Exception {
		if (!spaceEmpty()) {
            getTopTile().compareNeighbors(tile);
            Tile irrigation = new IrrigationTile(0);
            if(getTopTile().compareTo(irrigation))
                throw new OnIrrigationTile();
        }


		//onEdge();
		checkingOutSideJava(tile);
		tilesOnSpace.push(tile);


		System.out.println(this);
	}



    private void checkIrrigationSurrounding(Space space){

        int count = 0;

        for(Space s : space.getNeighbors())
            if(((HexSpace)s).getHeight() != 0)
                count++;

        if(count == 6)
            findHighestDev(space);

    }

    private void findHighestDev(Space space){

        int highestDev = 0;
        int highestHeight = 0;

        for(Space s : space.getNeighbors())
            if(((HexSpace)s).hasDeveloper()) {
               int height = ((HexSpace) s).getHeight();
               if(highestHeight < height)
                   highestHeight = height;

            }



        System.out.println("kkmsdfkmkmfkmmkfdmaskfmsakmfaasdmfkamkfmasdkmfksamfkdsaklf" + highestHeight);

    }

	private void checkingOutSideJava(Tile tile) throws SpaceNotOnEdgeException {

		boolean checkingOne = true;
		boolean checkingCurrent = true;

		for (int i = 0; i < tile.getNeighborsIndex().length; i++) {
			Space a = getNeighbor(tile.getNeighborsIndex()[i]);
			if (a != null && !a.onBorder())
				checkingOne = false;
		}

		checkingCurrent = getCurrentSpace().onBorder();

		if (checkingOne && checkingCurrent)
			throw new SpaceNotOnEdgeException("Cannot place all tiles outside java!");
	}

	protected void checkHeights(Tile tile) throws TileHeightWrongException {

		Set<Integer> heights = new HashSet<Integer>();

		heights.add(getHeight());

		int length = tile.getNeighborsIndex().length;

		for (int a : tile.getNeighborsIndex())
			heights.add(((HexSpace) getNeighbor(a)).getHeight());

		IrrigationTile a = new IrrigationTile(0);
		if (a.compareTo(tile))
			if (((HexSpace) getCurrentSpace()).getHeight() != 0)
				throw new TileHeightWrongException(
						"You can only place an Irrigation Tile on an empty space");

		if (heights.size() != 1 && length != 0)
			throw new TileHeightWrongException(
					"Tile heights are inconsistent in the area the block is being placed.");

	}

	public void updateNeighbor(Space s, Tile t) throws Exception {
		((HexSpace) s).place(t);
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



	public String toString() {
		String space = "";
		if (getHeight() > 0)
			space += "Tile on Space: " + getTopTile() + " neighbors" + "the heigh is: "
					+ getHeight() + "\n";
		else
			space += "The height is 0.";

		return space;
	}
}
