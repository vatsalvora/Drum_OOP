package model.commands;

import model.Command;
import model.GameFacade;

public class DrawPalaceCard implements Command {
    private GameFacade b;
    private boolean save;

    public DrawPalaceCard(GameFacade b) {
        this.b = b;
        save = true;
    }

    public void execute() {
        try {
            b.drawFestivalCard();
        }
        catch(Exception e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.render();
        }
    }

    public void undo() {
        b.returnFestivalCard();
    }

    public boolean save()
    {
        return save;
    }

    public String toString() {
        return this.getClass().getName();
    }
}
