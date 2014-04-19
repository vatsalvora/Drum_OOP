package model.commands;

import model.Command;
import model.GameFacade;

public class Move9 implements Command {
	private GameFacade b;

	public Move9(GameFacade b) {
		this.b = b;
	}

	// TODO which Location of the three land tiles is l?
	public void execute() {
		b.move9();
	}

	public void undo() {

	}

	public String toString() {
		return this.getClass().getName();
	}
}
