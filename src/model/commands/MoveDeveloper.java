package model.commands;

import model.Command;
import model.GameFacade;

public class MoveDeveloper implements Command {
    private GameFacade b;
    private boolean save;
    private int APUsed;

    public MoveDeveloper(GameFacade b) {
        this.b = b;
        save = true;
        APUsed = 0;
    }

    public MoveDeveloper(GameFacade b, int APUsed) {
        this.b = b;
        this.APUsed = APUsed;
    }

    public void execute() {
        try {
            b.moveDeveloper();
            try {
                APUsed = b.useDevMoveAP();
            }
            catch(Exception e)
            {
                b.unMoveDeveloper();
                save = false;
                b.sendErrorMessage(e.toString());
                b.render();
            }
        }
        catch(Exception e)
        {
            save = false;
            b.sendErrorMessage(e.toString());
            b.render();
        }
    }

    public void undo() {
        b.unuseDevMoveAP();
        b.unMoveDeveloper();
    }

    public boolean save()
    {
        return save;
    }

    public String toString() {
        return this.getClass().getName() + " " + APUsed;
    }
}
