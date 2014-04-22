package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

public class PlaceDeveloper implements Command {
    private GameFacade gameFacade;
    private boolean save;
    private int APForPlacement;
    private Color cornflower_blue = new Color(100, 149, 237);

    public PlaceDeveloper(GameFacade gameFacade) {
        this.gameFacade = gameFacade;

        save = true;
        Color color = gameFacade.getCurrentPlayerColor();
        int[] rotation = new int[0];
        gameFacade.setRotation(rotation);
        gameFacade.setMovementColor(cornflower_blue);
        gameFacade.setDevColor(color);
        gameFacade.render();
        APForPlacement = 0;
    }

    public PlaceDeveloper(GameFacade gameFacade, int APForPlacement) {
        this.gameFacade = gameFacade;
        this.APForPlacement = APForPlacement;
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
