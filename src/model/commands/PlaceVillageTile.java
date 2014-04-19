package model.commands;

import model.Command;
import model.GameFacade;

public class PlaceVillageTile implements Command {
	private GameFacade b;

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
		return this.getClass().getName();
	}
}
