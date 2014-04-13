package model;

public class PlaceIrrigationTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceIrrigationTile(GameFacade b, Location l) {
		this.b = b;
		this.l = l;
	}

	public void execute() {
		b.placeIrrigationTile(l);
	}

	public void undo() {

	}
}
