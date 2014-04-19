package model.commands;

import model.Command;
import model.GameFacade;

public class EndPalaceFestival implements Command {
    private GameFacade gameFacade;

    public EndPalaceFestival(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    @Override
    public void execute() {
        gameFacade.endPalaceFestival();
    }


    @Override
    public void undo() {

    }

    @Override
    public String toString() {
		return this.getClass().getName();
    }
}
