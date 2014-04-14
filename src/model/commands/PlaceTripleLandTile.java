package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

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
