package model.commands;

import model.Command;
import model.GameFacade;

public class InitiatePalaceFestival implements Command {
	private GameFacade b;

	public InitiatePalaceFestival(GameFacade b) {
		this.b = b;
	}

	public void execute() {
		b.initiatePalaceFestival();
	}

	public void undo() {

	}
}