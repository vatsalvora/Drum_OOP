package model;

import model.customExceptions.BlockNotPlayedException;

public class ChangeTurn implements Command {
	private GameFacade gameFacade;

	public ChangeTurn(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	@Override
	public void execute() {
		try {
            gameFacade.changeTurn();
        }
        catch(BlockNotPlayedException e){
            System.out.println(e.toString());
        }
	}

	@Override
	public void undo() {

	}
}
