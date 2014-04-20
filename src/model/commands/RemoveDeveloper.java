package model.commands;

import model.Command;
import model.GameFacade;

public class RemoveDeveloper implements Command {
    private GameFacade gameFacade;
    private boolean save;
    private int APForPlacement;

    public RemoveDeveloper(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
        save = true;
        APForPlacement = 0;
    }

    public void execute() {
        try {
            APForPlacement = gameFacade.removeDeveloper();
            try{
                gameFacade.pushDeveloper(APForPlacement);
            }
            catch(Exception e)
            {
                try {
                    gameFacade.replaceDeveloper();
                }
                catch(Exception f)
                {
                    //should never occur
                }
                save = false;
                gameFacade.sendErrorMessage(e.toString());
            }
        } catch (Exception e) {
            save = false;
            gameFacade.sendErrorMessage(e.toString());
        }
    }

    public void undo() {
        try {
            gameFacade.undoDeveloperRemoval(APForPlacement);
        }
        catch(Exception e)
        {
            //should never happen
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