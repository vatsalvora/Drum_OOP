package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

public class PlaceVillageTile implements Command {
	private GameFacade b;
    private int points;
    private boolean save;
    private Color cornflower_blue = new Color(100, 149, 237);

	public PlaceVillageTile(GameFacade b) {
		this.b = b;
        b.setMovementColor(Color.RED);
        int[] rotation = new int[0];
        b.setRotation(rotation);
        b.setDevColor(Color.RED);
        b.render();
        points = 0;
        save = true;
	}

    public PlaceVillageTile(GameFacade b, int points)
    {
        this.b = b;
        this.points = points;
        save = true;
    }

    public void execute() {
        try {
            b.pullVillageTile();
            try{
                points = b.placeVillageTile();
                //save self
            }
            catch(Exception e)
            {
                save = false;
                b.returnVillageTile();
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
        b.undoVillageTile(points);
    }

    public boolean save()
    {
        return save;
    }

    public String toString() {
        return this.getClass().getName() + " " + points;
    }
}
