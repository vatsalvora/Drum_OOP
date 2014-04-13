package model;

public class ChangeTurn implements Command {
	private GameFacade gameFacade;

	public ChangeTurn(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	@Override
	public void execute() {
		gameFacade.changeTurn();
	}

	@Override
	public void undo() {

	}
}
