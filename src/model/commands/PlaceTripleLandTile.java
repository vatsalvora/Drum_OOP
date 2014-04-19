package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

public class PlaceTripleLandTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceTripleLandTile(GameFacade b) {
		this.b = b;
	}

	// TODO which Location of the three land tiles is l?
	@Override
	public void execute() {
		b.placeTripleLandTile();
	}

	@Override
	public void undo() {

	}

	@Override
	public String toString() {
		return this.getClass().getName() + " " + l.getXLocation() + " " + l.getYLocation();
	}
}
