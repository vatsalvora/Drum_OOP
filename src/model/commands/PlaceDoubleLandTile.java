package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

public class PlaceDoubleLandTile implements Command {
    private GameFacade b;
    private int points;
    private boolean save;
    private int[] rotation;
    private Color cornflower_blue = new Color(100, 149, 237);
    public PlaceDoubleLandTile(GameFacade b) {
        this.b = b;
        points = 0;
        save = true;
    }

    public PlaceDoubleLandTile(GameFacade b, int p)
    {
        this.b = b;
        points = p;
        save = true;
    }

    public void execute() {
        try{
            b.pullTwoBlock();
            try {
                points = b.placeTwoBlock();
            }
            catch(Exception e)
            {
                save = false;
                b.returnTwoBlock();
                b.sendErrorMessage(e.toString());
                b.resetView();
            }
        }
        catch(Exception e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.resetView();

        }


    }

    public void undo() {
        b.undoTwoBlock(0);
    }

    public boolean save()
    {
        return save;
    }

    public String toString() {
        return this.getClass().getName() + " " + points;
    }
}
