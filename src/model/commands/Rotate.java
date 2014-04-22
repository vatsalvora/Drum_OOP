package model.commands;

import model.Command;
import model.GameFacade;

public class Rotate implements Command {
	private GameFacade gameFacade;

	public Rotate(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	public void execute() {
		gameFacade.rotate();
	}

	public void undo() {

	}

    public boolean save()
    {
        return true;
    }

	@Override
	public String toString() {
		String ret = this.getClass().getName();
        for(int i : gameFacade.getRotation()){
                ret += " " + i;
        }
        return ret;
	}
}
