package model.commands;

import model.Command;
import model.GameFacade;

/**
 * Created by Vatsal on 4/20/2014.
 */
public class SetRotation implements Command {
    private GameFacade b;
    private int[] rotation;
    public SetRotation(GameFacade b, int[] rotation){
        this.b = b;
        this.rotation = rotation;
    }
    @Override
    public void execute() {
        b.setRotation(rotation);
    }

    @Override
    public void undo() {
        b.setRotation(new int[0]);
    }

    @Override
    public boolean save() {
        return true;
    }

    public String toString() {
        return this.getClass().getName();
    }
}
