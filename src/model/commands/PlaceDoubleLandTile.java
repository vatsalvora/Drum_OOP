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

	public void execute() {
		b.placeDoubleLandTile(l);
	}

	public void undo() {

	}
}
