package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

public class PlaceVillageTile implements Command {
	private GameFacade b;
	private Location l;

	public PlaceVillageTile(GameFacade b, Location l) {
		this.b = b;
		this.l = l;
	}

	public void execute() {
		b.placeVillageTile(l);
	}

	public void undo() {

	}
}
