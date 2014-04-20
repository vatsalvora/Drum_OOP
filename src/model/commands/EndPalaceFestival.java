package model.commands;

import model.Command;
import model.GameFacade;

public class EndPalaceFestival implements Command {
    private GameFacade gameFacade;
    private boolean save;

    public EndPalaceFestival(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
        save = true;
    }

    @Override
    public void execute() {
        gameFacade.endPalaceFestival();
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
