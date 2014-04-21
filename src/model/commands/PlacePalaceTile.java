package model.commands;

import model.Command;
import model.GameFacade;
import model.customExceptions.NoPalaceTilesLeft;
import model.customExceptions.NotEnoughAPException;

import java.awt.*;

public class PlacePalaceTile implements Command {
    private GameFacade b;
    private int level;
    private int points;
    private boolean save;
    private Color cornflower_blue = new Color(100, 149, 237);

    public PlacePalaceTile(GameFacade b, int level) {
        this.b = b;
        this.level = level;
        points = 0;
        save = true;
    }

    public PlacePalaceTile(GameFacade b, int level, int points) {
        this.b = b;
        this.level = level;
        this.points = points;
        save = true;
    }

    public void execute() {
        try {
            b.pullPalaceTile(level);
            try {
                b.placeOtherBlock();
                try {
                    points = b.placePalaceTile(level);
                } catch (Exception e) {
                    save = false;
                    b.returnPalaceTile(level);
                    b.returnOtherBlock();
                    b.resetView();
                }
            } catch (NotEnoughAPException e) {
                save = false;
                b.returnPalaceTile(level);
                b.sendErrorMessage(e.toString());
                b.resetView();
            }
        } catch (NoPalaceTilesLeft e) {
            save = false;
            b.sendErrorMessage(e.toString());
            b.resetView();
        }
    }

    public void undo() {
        b.undoPalaceTile(level, points);
    }

    public boolean save() {
        return save;
    }

    public String toString() {
        return this.getClass().getName() + " " + level + " " + points;
    }
}
