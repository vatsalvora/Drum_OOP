package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoThreeBlockLeftException;
import model.customExceptions.NotEnoughAPException;

import java.awt.*;

public class PlaceTripleLandTile implements Command {
    private GameFacade b;
    private int points;
    private boolean save;
    private Color cornflower_blue = new Color(100, 149, 237);

    public PlaceTripleLandTile(GameFacade b) {
        this.b = b;
        int[] rotation = {2,3};
        b.setRotation(rotation);
        b.setMovementColor(Color.MAGENTA);
        b.setDevColor(Color.MAGENTA);
        b.render();
        points = 0;
        save = true;
    }

    public PlaceTripleLandTile(GameFacade b, int points)
    {
        this.b = b;
        this.points = points;
        save = true;
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
                    save = false;
                    b.returnThreeBlock();
                    b.sendErrorMessage(e.toString());
                    int[] rotation = new int[0];
                    b.setRotation(rotation);
                    b.setDevColor(cornflower_blue);
                    b.setMovementColor(new Color(100, 149, 237));
                    b.render();
                }
            }
            catch(NotEnoughAPException e)
            {
                save = false;
                b.returnThreeBlock();
                b.sendErrorMessage(e.toString());
                int[] rotation = new int[0];
                b.setRotation(rotation);
                b.setDevColor(cornflower_blue);
                b.setMovementColor(new Color(100, 149, 237));
                b.render();
            }
        }
        catch(NoThreeBlockLeftException e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            int[] rotation = new int[0];
            b.setRotation(rotation);
            b.setDevColor(cornflower_blue);
            b.setMovementColor(new Color(100, 149, 237));
            b.render();
        }
    }

    public void undo() {
        b.undoThreeBlock(points);
    }

    public boolean save()
    {
        return save;
    }

    public String toString() {
        return this.getClass().getName() + " " + points;
    }
}
