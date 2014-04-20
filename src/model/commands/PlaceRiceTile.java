package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

public class PlaceRiceTile implements Command {
	private GameFacade b;
    private int points;
    private boolean save;

	public PlaceRiceTile(GameFacade b) {
		this.b = b;
        b.setMovementColor(Color.GREEN);
        int[] rotation = new int[0];
        b.setRotation(rotation);
        b.render();
        points = 0;
        save = true;
	}

    public PlaceRiceTile(GameFacade b, int p)
    {
        this.b = b;
        points = p;
        save = true;
    }

	public void execute() {
        try{
            b.pullRiceTile();
            try {
                points = b.placeRiceTile();
            }
            catch(Exception e)
            {
                save = false;
                b.returnRiceTile();
                b.sendErrorMessage(e.toString());
                b.setMovementColor(new Color(100, 149, 237));
                b.render();
            }
        }
        catch(Exception e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.setMovementColor(new Color(100, 149, 237));
            b.render();
        }


	}

	public void undo() {
        b.undoRiceTile(points);
	}

    public boolean save()
    {
        return save;
    }

	public String toString() {
		return this.getClass().getName() + " " + points;
	}
}
