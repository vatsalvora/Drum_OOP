package model;

public class PlaceRiceTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceRiceTile(GameFacade b, Location l) {
		this.b = b;
		this.l = l;
	}

	public void execute() {
		b.placeRiceTile(l);
	}

	public void undo() {

	}
}
