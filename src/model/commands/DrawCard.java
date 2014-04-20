package model.commands;

import model.Command;
import model.GameFacade;

public class DrawCard implements Command {
    private GameFacade b;
    private boolean save;

    public DrawCard(GameFacade b) {
        this.b = b;
        save = true;
    }

    public void execute() {
        try {
            b.drawCard();
        }
        catch(Exception e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.render();
        }
    }

    public void undo() {
        b.undoDrawCard();
    }

    public boolean save()
    {
        return save;
    }

    public String toString() {
        return this.getClass().getName();
    }
}
