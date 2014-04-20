package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoIrrigationLeftException;
import model.customExceptions.NotEnoughAPException;

import java.awt.*;

public class PlaceIrrigationTile implements Command {
	private GameFacade b;
    private int points;

	public PlaceIrrigationTile(GameFacade b) {
		this.b = b;
        b.setMovementColor(Color.BLUE);
        int[] rotation = new int[0];
        b.setRotation(rotation);
        b.render();
        points = 0;
	}

    public PlaceIrrigationTile(GameFacade b, int points)
    {
        this.b = b;
        this.points = points;
    }

	public void execute() {
        try {
            b.pullIrrigationTile();
            try{
                try{
                    points = b.placeIrrigationTile();
                    //save self
                }
                catch(Exception e)
                {
                    b.returnIrrigationTile();
                    b.sendErrorMessage(e.toString());
                    b.setMovementColor(new Color(100, 149, 237));
                    b.render();
                }
            }
            catch(Exception e)
            {
                b.returnIrrigationTile();
                b.sendErrorMessage(e.toString());
                b.setMovementColor(new Color(100, 149, 237));
                b.render();
            }
        }
        catch(NoIrrigationLeftException e)
        {
            b.sendErrorMessage(e.toString());
            b.setMovementColor(new Color(100, 149, 237));
            b.render();
        }
	}

	public void undo() {
        b.undoIrrigationTile(points);
	}

	public String toString() {
		return this.getClass().getName() + " " + points;
	}

}
