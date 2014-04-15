package model.commands;

import model.Command;
import model.GameFacade;

public class ChangeTurn implements Command {
	private GameFacade gameFacade;

	public ChangeTurn(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	public void execute() {
		gameFacade.changeTurn();
	}

	public void undo() {

	}
}
