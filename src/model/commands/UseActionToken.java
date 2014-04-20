package model.commands;

import model.Command;
import model.GameFacade;

public class UseActionToken implements Command {
    private GameFacade b;
    private boolean save;

    public UseActionToken(GameFacade b) {
        this.b = b;
        save = true;
    }

    public void execute() {
        try {
            b.useActionToken();
        }
        catch(Exception e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.render();
        }
    }

    public void undo() {
        b.undoActionToken();
    }

    public boolean save()
    {
        return save;
    }

    public String toString() {
        return this.getClass().getName();
    }
}
