package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoIrrigationLeftException;
import model.customExceptions.NotEnoughAPException;

public class PlaceIrrigationTile implements Command {
	private GameFacade b;
    private int points;

	public PlaceIrrigationTile(GameFacade b) {
		this.b = b;
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
                b.placeOtherBlock();
                try{
                    points = b.placeIrrigationTile();
                    //save self
                }
                catch(Exception e)
                {
                    b.returnIrrigationTile();
                    b.sendErrorMessage(e.toString());
                }
            }
            catch(NotEnoughAPException e)
            {
                b.returnIrrigationTile();
                b.sendErrorMessage(e.toString());
            }
        }
        catch(NoIrrigationLeftException e)
        {
            b.sendErrorMessage(e.toString());
        }
	}

	public void undo() {
        b.undoIrrigationTile(points);
	}

	public String toString() {
		return this.getClass().getName() + points;
	}

}
