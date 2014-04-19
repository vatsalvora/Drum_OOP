package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

public class PlaceDoubleLandTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceDoubleLandTile(GameFacade b, Location l) {
		this.b = b;
		this.l = l;
	}

	// TODO which Location of the three land tiles is l?
	public void execute() {
		b.placeDoubleLandTile(l);
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName() + " " + l.getXLocation() + " " + l.getYLocation();
	}
}
