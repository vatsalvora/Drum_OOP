package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.LocationOutOfBoundsException;

public class Move3 implements Command {
	private GameFacade b;
    private boolean save;

	public Move3(GameFacade b) {
		this.b = b;
        save = true;
	}

	public void execute() {
        try {
            b.move3();
        }
        catch(LocationOutOfBoundsException e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
        }
	}

	public void undo() {
        try{
            b.move7();
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
