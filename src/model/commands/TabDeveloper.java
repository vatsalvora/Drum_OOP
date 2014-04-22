package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

public class TabDeveloper implements Command {
	private GameFacade b;
	private boolean save;
	private Color cornflower_blue = new Color(100, 149, 237);

	public TabDeveloper(GameFacade b) {
		this.b = b;
		save = true;
	}

	public void execute() {

	}

	public void undo() {

	}

	public boolean save() {
		return save;
	}

	public String toString() {
		return this.getClass().getName();
	}
}
