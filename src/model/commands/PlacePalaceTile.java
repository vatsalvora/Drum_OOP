package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

public class PlacePalaceTile implements Command {
	private GameFacade b;
	private Location l;

	public PlacePalaceTile(GameFacade b, Location l) {
		this.b = b;
		this.l = l;
	}

	public void execute() {
		b.placePalaceTile(l);
	}

	public void undo() {

	}

	public String toString() {
		StringBuilder result = new StringBuilder(100);
		result.append(this.getClass().getName() + " " + l.getXLocation() + " " + l.getYLocation());
		return result.toString();
	}
}
