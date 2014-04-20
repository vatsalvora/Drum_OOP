package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoPalaceTilesLeft;
import model.customExceptions.NotEnoughAPException;

public class PlacePalaceTile implements Command {
	private GameFacade b;
    private int level;
    private int points;

	public PlacePalaceTile(GameFacade b, int level) {
		this.b = b;
        this.level = level;
        points = 0;
	}

    public PlacePalaceTile(GameFacade b, int level, int points)
    {
        this.b = b;
        this.level = level;
        this.points = points;
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
                    b.returnPalaceTile(level);
                    b.returnOtherBlock();
                    b.sendErrorMessage(e.toString());
                }
            }
            catch(NotEnoughAPException e)
            {
                b.returnPalaceTile(level);
                b.sendErrorMessage(e.toString());
            }
        }
        catch(NoPalaceTilesLeft e){
            b.sendErrorMessage(e.toString());
        }
	}

	public void undo() {
        b.undoPalaceTile(level, points);
	}

	public String toString() {
		return this.getClass().getName() + " " + points;
	}
}
