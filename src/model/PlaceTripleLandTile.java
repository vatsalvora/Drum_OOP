package model;

public class PlaceTripleLandTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceTripleLandTile(GameFacade b, Location l) {
		this.b = b;
		this.l = l;
	}

	public void execute() {
		b.placeTripleLandTile(l);
	}

	public void undo() {

	}
}
