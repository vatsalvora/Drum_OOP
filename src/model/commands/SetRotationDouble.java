package model.commands;

import model.Command;
import model.GameFacade;

/**
 * Created by Vatsal on 4/20/2014.
 */
public class SetRotationDouble implements Command {
    private GameFacade b;
    public SetRotationDouble(GameFacade b){
        this.b = b;
    }
    @Override
    public void execute() {
        b.setRotation(new int[]{2});
    }

    @Override
    public void undo() {
        b.setRotation(new int[0]);
    }

    @Override
    public boolean save() {
        return true;
    }
}
