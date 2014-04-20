package model;

import model.customExceptions.BlockNotPlayedException;

public class ChangeTurn implements Command {
	private GameFacade gameFacade;
    private boolean save;

	public ChangeTurn(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
        save = true;
	}

	@Override
	public void execute() {
		try {
            gameFacade.changeTurn();
        }
        catch(BlockNotPlayedException e){
            save = false;
            gameFacade.sendErrorMessage(e.toString());
        }
	}

	@Override
	public void undo() {
        gameFacade.undoChangeTurn();
	}

    public boolean save()
    {
        return save;
    }
}
