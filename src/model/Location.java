package model;

public class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getXLocation() {
		return x;
	}

	public int getYLocation() {
		return y;
	}

    public void setLocation(int xLoc, int yLoc){
        x = xLoc;
        y = yLoc;
    }

    public String toString(){
        return ("(" + x + ", " + y + ")");
    }
}
