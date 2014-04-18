package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.BlockNotPlayedException;

public class ChangeTurn implements Command {
	private GameFacade gameFacade;

	public ChangeTurn(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	public void execute()
    {
        try {
            gameFacade.changeTurn();
        }
        catch (BlockNotPlayedException e)
        {
            //do something with the exception
        }
	}

	public void undo() {

	}

    @Override
    public String toString(){
        return "Changing turns";
    }
}
