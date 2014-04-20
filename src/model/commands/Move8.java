package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.LocationOutOfBoundsException;

public class Move8 implements Command {
	private GameFacade b;
    private boolean save;

	public Move8(GameFacade b) {
		this.b = b;
        save = true;
	}

	// TODO which Location of the three land tiles is l?
	public void execute() {
        try {
            b.move8();
        }
        catch(LocationOutOfBoundsException e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
        }
	}

	public void undo() {
        try{
            b.move2();
        }
        catch(LocationOutOfBoundsException e)
        {
            //do nothing, should never happen
        }
	}

    public boolean save()
    {
        return save;
    }

	public String toString() {
		return this.getClass().getName();
	}
}
