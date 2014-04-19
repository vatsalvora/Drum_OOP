package model.commands;

import model.Command;
import model.GameFacade;

public class PlaceRiceTile implements Command {
	private GameFacade b;

	public PlaceRiceTile(GameFacade b) {
		this.b = b;
	}

	public void execute() {
		b.placeRiceTile();
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName();
	}
}
