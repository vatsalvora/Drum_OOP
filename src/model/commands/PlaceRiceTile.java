package model.commands;

import model.Command;
import model.GameFacade;

public class PlaceRiceTile implements Command {
	private GameFacade b;
    private int points;

	public PlaceRiceTile(GameFacade b) {
		this.b = b;
        points = 0;
	}

    public PlaceRiceTile(GameFacade b, int p)
    {
        this.b = b;
        points = p;
    }

	public void execute() {
        try{
            b.pullRiceTile();
            try {
                points = b.placeRiceTile();
            }
            catch(Exception e)
            {
                b.returnRiceTile();
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
		return this.getClass().getName() + points;
	}
}
