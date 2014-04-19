package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

public class PlaceVillageTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceVillageTile(GameFacade b) {
		this.b = b;
	}

	@Override
	public void execute() {
		b.placeVillageTile();
	}

	@Override
	public void undo() {

	}

	@Override
	public String toString() {
		return this.getClass().getName() + " " + l.getXLocation() + " " + l.getYLocation();
	}
}
