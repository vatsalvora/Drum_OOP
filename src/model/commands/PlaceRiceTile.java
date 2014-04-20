package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

public class PlaceRiceTile implements Command {
	private GameFacade b;
    private int points;

	public PlaceRiceTile(GameFacade b) {
		this.b = b;
        b.setMovementColor(Color.GREEN);
        int[] rotation = new int[0];
        b.setRotation(rotation);
        b.render();
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
                b.setMovementColor(new Color(100, 149, 237));
                b.render();
            }
        }
        catch(Exception e)
        {
            b.sendErrorMessage(e.toString());
            b.setMovementColor(new Color(100, 149, 237));
            b.render();
        }


	}

	public void undo() {
        b.undoRiceTile(points);
	}

	public String toString() {
		return this.getClass().getName() + " " + points;
	}
}
