package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.BlockNotPlayedException;

public class ChangeTurn implements Command {
	private GameFacade gameFacade;
    private boolean save;

	public ChangeTurn(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
        save = true;
	}

	public void execute() {
		try {
			gameFacade.changeTurn();
		} catch (BlockNotPlayedException e) {
            save = false;
			gameFacade.sendErrorMessage(e.toString());
		}
	}

	public void undo() {
          gameFacade.undoChangeTurn();
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
