package model.commands;

import model.Command;
import model.GameFacade;

public class Rotate implements Command {
	private GameFacade gameFacade;

	public Rotate(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	public void execute() {
		gameFacade.rotate();
	}

	public void undo() {

	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
