package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;

public class PlacePalaceTile implements Command {
	private GameFacade b;
	private Location l;
    private int level;

	public PlacePalaceTile(GameFacade b, Location l, int level) {
		this.b = b;
		this.l = l;
        this.level = level;
	}

	public void execute() {
		b.placePalaceTile(b.getCurrentSpace(), level);
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName() + " " + l.getXLocation() + " " + l.getYLocation();
	}
}
