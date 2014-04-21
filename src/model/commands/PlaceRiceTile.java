package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

public class PlaceRiceTile implements Command {
	private GameFacade b;
    private int points;
    private boolean save;
    private Color cornflower_blue = new Color(100, 149, 237);

	public PlaceRiceTile(GameFacade b) {
		this.b = b;
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
                b.resetView();
            }
        }
        catch(Exception e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.resetView();
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
