package model.commands;

import model.Command;
import model.GameFacade;

public class PlaceDoubleLandTile implements Command {
	private GameFacade b;

	public PlaceDoubleLandTile(GameFacade b) {
		this.b = b;
	}

	// TODO which Location of the three land tiles is l?
	public void execute() {
		b.placeDoubleLandTile();
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName();
	}
}
