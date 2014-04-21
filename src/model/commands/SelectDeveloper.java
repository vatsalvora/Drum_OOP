package model.commands;

import model.Command;
import model.GameFacade;

public class SelectDeveloper implements Command {
    private GameFacade b;
    private boolean save;

    public SelectDeveloper(GameFacade b) {
        this.b = b;
        save = true;
    }

    public void execute() {
        try {
            b.selectDeveloper();
        }
        catch(Exception e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.render();
        }
    }

    public void undo() {
        b.deselectDeveloper();
    }

    public boolean save()
    {
        return save;
    }

    public String toString() {
        return this.getClass().getName();
    }
}
