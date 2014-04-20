package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

public class PlaceDoubleLandTile implements Command {
    private GameFacade b;
    private int points;

    public PlaceDoubleLandTile(GameFacade b) {
        this.b = b;
        int[] rotation = {2};
        b.setRotation(rotation);
        b.setMovementColor(Color.GREEN);
        b.render();
        points = 0;

    }

    public PlaceDoubleLandTile(GameFacade b, int p)
    {
        this.b = b;
        points = p;
    }

    public void execute() {
        try{
            b.pullTwoBlock();
            try {
                points = b.placeTwoBlock();
            }
            catch(Exception e)
            {
                b.returnTwoBlock();
                b.sendErrorMessage(e.toString());
            }
        }
        catch(Exception e)
        {
            b.sendErrorMessage(e.toString());
        }


    }

    public void undo() {
        b.undoRiceTile(points);
    }

    public String toString() {
        return this.getClass().getName() + " " + points;
    }
}
