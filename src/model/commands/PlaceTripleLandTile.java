package model.commands;

import model.Command;
import model.GameFacade;

public class PlaceTripleLandTile implements Command {
	private GameFacade b;

	public PlaceTripleLandTile(GameFacade b) {
		this.b = b;
	}

	// TODO which Location of the three land tiles is l?
	public void execute() {
		b.placeTripleLandTile();
	}

	@Override
	public void undo() {

	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
