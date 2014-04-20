package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.LocationOutOfBoundsException;

public class Move1 implements Command {
	private GameFacade b;
    private boolean save;

	public Move1(GameFacade b) {
		this.b = b;
        save = true;
	}

	public void execute() {
		try {
            b.move1();
        }
        catch(LocationOutOfBoundsException e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
        }
	}

	public void undo() {
        try {
            b.move9();
        }
        catch(LocationOutOfBoundsException e)
        {
            //do nothing with exception, should never be thrown here
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
