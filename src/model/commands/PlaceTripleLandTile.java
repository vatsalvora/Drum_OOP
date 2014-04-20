package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoThreeBlockLeftException;
import model.customExceptions.NotEnoughAPException;

public class PlaceTripleLandTile implements Command {
    private GameFacade b;
    private int points;

    public PlaceTripleLandTile(GameFacade b) {
        this.b = b;
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
                    points = b.placeIrrigationTile();
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
        return this.getClass().getName() + points;
    }
}
