package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoThreeBlockLeftException;
import model.customExceptions.NotEnoughAPException;

import java.awt.*;

public class PlaceTripleLandTile implements Command {
    private GameFacade b;
    private int points;

    public PlaceTripleLandTile(GameFacade b) {
        this.b = b;
        int[] rotation = {2,3};
        b.setRotation(rotation);
        b.setMovementColor(Color.MAGENTA);
        b.render();
        points = 0;
    }

    public PlaceTripleLandTile(GameFacade b, int points)
    {
        this.b = b;
        this.points = points;
    }

    public void execute() {
        try {
            b.pullThreeBlock();
            try{
                b.placeOtherBlock();
                try{
                    points = b.placeThreeBlock();
                    //save self
                }
                catch(Exception e)
                {
                    b.returnThreeBlock();
                    b.sendErrorMessage(e.toString());
                }
            }
            catch(NotEnoughAPException e)
            {
                b.returnThreeBlock();
                b.sendErrorMessage(e.toString());
            }
        }
        catch(NoThreeBlockLeftException e)
        {
            b.sendErrorMessage(e.toString());
        }
    }

    public void undo() {
        b.undoThreeBlock(points);
    }

    public String toString() {
        return this.getClass().getName() + " " + points;
    }
}
