package model.commands;

import model.Command;
import model.GameFacade;
import model.Location;
import model.customExceptions.NoIrrigationLeftException;
import model.customExceptions.NotEnoughAPException;

public class PlaceIrrigationTile implements Command {
	private GameFacade b;
	private Location l;
    private int points;

	public PlaceIrrigationTile(GameFacade b) {
		this.b = b;
        points = 0;
	}

    public PlaceIrrigationTile(GameFacade b, Location l, int points)
    {
        this.b = b;
        this.l = l;
        this.points = points;
    }

	public void execute() {
        try {
            b.pullIrrigationTile();
            try{
                b.placeOtherBlock();
                try{
                    points = b.placeIrrigationTile();
                }
                catch(Exception e)
                {
                    b.returnIrrigationTile();
                    b.returnOtherBlock();
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
		return this.getClass().getName() + " " + l.getXLocation() + " " + l.getYLocation() + " " + points;
	}

}
