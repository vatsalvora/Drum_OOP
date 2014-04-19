package model.commands;

import model.Command;
import model.GameFacade;

public class InitiatePalaceFestival implements Command {
	private GameFacade b;

	public InitiatePalaceFestival(GameFacade b) {
		this.b = b;
	}

	@Override
	public void execute() {
		b.initiatePalaceFestival();
	}

	@Override
	public void undo() {

	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
