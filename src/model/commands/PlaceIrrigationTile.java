package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoIrrigationLeftException;

import java.awt.*;

public class PlaceIrrigationTile implements Command {
	private GameFacade b;
    private int points;
    private boolean save;
    private Color cornflower_blue = new Color(100, 149, 237);

	public PlaceIrrigationTile(GameFacade b) {
        save = true;
		this.b = b;
        points = 0;
	}

    public PlaceIrrigationTile(GameFacade b, int points)
    {
        save = true;
        this.b = b;
        this.points = points;
    }

	public void execute() {
        try {
            b.pullIrrigationTile();
            try{
                try{
                    points = b.placeIrrigationTile();
                }
                catch(Exception e)
                {
                    save = false;
                    b.returnIrrigationTile();
                    b.sendErrorMessage(e.toString());
                    b.resetView();
                }
            }
            catch(Exception e)
            {
                save = false;
                b.returnIrrigationTile();
                b.sendErrorMessage(e.toString());
                b.resetView();
            }
        }
        catch(NoIrrigationLeftException e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.resetView();
        }
	}

	public void undo() {
        b.undoIrrigationTile(points);
	}

    public boolean save()
    {
        return save;
    }

	public String toString() {
		return this.getClass().getName() + " " + points;
	}

}
