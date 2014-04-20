package model.commands;

import model.Command;
import model.GameFacade;

public class PlaceDeveloper implements Command {
    private GameFacade gameFacade;
    private boolean save;
    private int APForPlacement;

    public PlaceDeveloper(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
        save = true;
        APForPlacement = 0;
    }

    public void execute() {
        try {
            APForPlacement = gameFacade.placeDeveloper();
            try{
                gameFacade.pullDeveloper(APForPlacement);
            }
            catch(Exception e)
            {
                gameFacade.removeDeveloper();
                save = false;
                gameFacade.sendErrorMessage(e.toString());
            }
        } catch (Exception e) {
            save = false;
            gameFacade.sendErrorMessage(e.toString());
        }
    }

    public void undo() {
        try{
            gameFacade.undoDeveloperPlacement(APForPlacement);
        }
        catch(Exception e)
        {
            //should never occur
        }
    }

    public boolean save()
    {
        return save;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " " + APForPlacement;
    }
}
