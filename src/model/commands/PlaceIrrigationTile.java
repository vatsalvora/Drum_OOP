package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

public class PlaceIrrigationTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceIrrigationTile(GameFacade b) {
		this.b = b;
	}

	public void execute() {
		b.placeIrrigationTile();
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName() + " " + l.getXLocation() + " " + l.getYLocation();
	}

}
