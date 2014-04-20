package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoPalaceTilesLeft;
import model.customExceptions.NotEnoughAPException;

import java.awt.*;

public class PlacePalaceTile implements Command {
	private GameFacade b;
    private int level;
    private int points;
    private boolean save;

	public PlacePalaceTile(GameFacade b, int level) {
		this.b = b;
        this.level = level;
        b.setMovementColor(Color.YELLOW);
        int[] rotation = new int[0];
        b.setRotation(rotation);
        b.render();
        points = 0;
        save = true;
	}

    public PlacePalaceTile(GameFacade b, int level, int points)
    {
        this.b = b;
        this.level = level;
        this.points = points;
        save = true;
    }

	public void execute() {
        try{
            b.pullPalaceTile(level);
            try{
                b.placeOtherBlock();
                try{
                    points = b.placePalaceTile(level);
                }
                catch(Exception e)
                {
                    save = false;
                    b.returnPalaceTile(level);
                    b.returnOtherBlock();
                    b.sendErrorMessage(e.toString());
                    b.setMovementColor(new Color(100, 149, 237));
                    b.render();
                }
            }
            catch(NotEnoughAPException e)
            {
                save = false;
                b.returnPalaceTile(level);
                b.sendErrorMessage(e.toString());
                b.setMovementColor(new Color(100, 149, 237));
                b.render();
            }
        }
        catch(NoPalaceTilesLeft e){
            save = false;
            b.sendErrorMessage(e.toString());
            b.setMovementColor(new Color(100, 149, 237));
            b.render();
        }
	}

	public void undo() {
        b.undoPalaceTile(level, points);
	}

    public boolean save()
    {
        return save;
    }

	public String toString() {
		return this.getClass().getName() + " " + level + " " + points;
	}
}
