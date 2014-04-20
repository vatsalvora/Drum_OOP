package model.commands;

import model.Command;
import model.GameFacade;

public class InitiatePalaceFestival implements Command {
	private GameFacade b;
    private boolean save;

	public InitiatePalaceFestival(GameFacade b) {
		this.b = b;
        save = true;
	}

	@Override
	public void execute() {
		b.initiatePalaceFestival();
	}

	@Override
	public void undo() {

	}

    public boolean save()
    {
        return save;
    }

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
