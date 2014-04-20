package model.commands;

import model.Command;
import model.GameFacade;

public class PlacePalaceTile implements Command {
	private GameFacade b;
    private int level;

	public PlacePalaceTile(GameFacade b, int level) {
		this.b = b;
        this.level = level;
	}

	public void execute() {
		b.placePalaceTile(b.getCurrentSpace(), level);
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName();
	}
}
