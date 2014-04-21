package model.commands;

import model.Command;
import model.GameFacade;

import java.awt.*;

/**
 * Created by Vatsal on 4/21/2014.
 */
public class ChangeMovementColor implements Command {
    private Color devColor;
    private Color movment;
    private GameFacade b;
    private Color cornflower_blue = new Color(100, 149, 237);

    public ChangeMovementColor(GameFacade b, Color devColor, Color movment){
        this.devColor = devColor;
        this.movment = movment;
        this.b = b;
    }

    @Override
    public void execute() {
        b.setMovementColor(movment);
        b.setDevColor(devColor);
        b.render();

    }

    @Override
    public void undo() {
        b.setMovementColor(cornflower_blue);
        b.setDevColor(cornflower_blue);
        b.render();

    }

    @Override
    public boolean save() {
        return false;
    }
}
