package model.commands;

import model.Command;
import model.GameFacade;

public class Move3 implements Command {
	private GameFacade b;

	public Move3(GameFacade b) {
		this.b = b;
	}

	// TODO which Location of the three land tiles is l?
	public void execute() {
		b.move3();
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName();
	}
}
