package model.commands;

import model.Command;
import model.GameFacade;

/**
 * Created by Vatsal on 4/21/2014.
 */
public class ChangeLevelDisplay implements Command {
    private GameFacade gameFacade;
    private int lvl;

    public ChangeLevelDisplay(GameFacade gameFacade, int lvl){
        this.gameFacade = gameFacade;
        this.lvl = lvl;
    }

    @Override
    public void execute() {
        gameFacade.setPalaceLvl(lvl);
    }

    @Override
    public void undo() {
        gameFacade.setPalaceLvl(0);
    }

    @Override
    public boolean save() {
        return false;
    }
}
