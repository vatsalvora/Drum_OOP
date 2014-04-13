package model.commands;

import model.Command;
import model.GameFacade;

public class EndPalaceFestival implements Command {
	private GameFacade b;

	public EndPalaceFestival(GameFacade b) {
		this.b = b;
	}

	public void execute() {
		b.initiatePalaceFestival();
	}

	public void undo() {

	}
}
