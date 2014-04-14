package model.commands;

import model.Command;
import model.GameFacade;

public class EndPalaceFestival implements Command {
	private GameFacade gameFacade;

	public EndPalaceFestival(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	public void execute() {
		gameFacade.endPalaceFestival();
	}

	public void undo() {

	}
}
