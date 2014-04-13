package model;

public class ChangeTurn implements Command {
	private GameFacade b;

	public ChangeTurn(GameFacade b) {
		this.b = b;
	}

	@Override
	public void execute() {
		b.changeTurn();
	}

	@Override
	public void undo() {

	}
}
