package model.commands;

import java.lang.Thread.State;

import model.Command;
import model.GameFacade;
import model.state.Replay;

public class ChangeStateReplay implements Command {
	private GameFacade gameFacade;
	private boolean save;
	Replay s;

	public ChangeStateReplay(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
		s = new Replay();
	}

	public void execute() {
		System.out.print(s.getCurrentState());
	}

	public void undo() {
	}

	public boolean save() {
		return save;
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
