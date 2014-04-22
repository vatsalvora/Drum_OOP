package model.state;

import model.GameFacade;
import model.commands.CommandCreator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by devan on 4/9/14.
 */
public abstract class State {

    public static CommandCreator commandCreator;
    protected static GameFacade gameFacade;
    private final static Logger LOGGER = Logger.getLogger(State.class.getName());

    public State(GameFacade gameFacade) {
        commandCreator = new CommandCreator(gameFacade);
        this.gameFacade = gameFacade;
        System.out.println("gameFacade created");
    }
    public State(){

    }


    public void incorrectKeyPressed() {
        java.awt.Toolkit.getDefaultToolkit().beep();
        LOGGER.log(Level.WARNING, "Incorrect key pressed");
    }

    public abstract void keyPressed1() throws IOException;

    public abstract void keyPressed2();

    public abstract void keyPressed3();

    public abstract void keyPressed7();

    public abstract void keyPressed8();

    public abstract void keyPressed9();

    public abstract void keyPressedTab();

    public abstract void keyPressedR();

    public abstract void keyPressedP();

    public abstract void keyPressedV();

    public abstract void keyPressedI();

    public abstract void keyPressedX();

    public abstract void keyPressedA();

    public abstract void keyPressedESC();

    public abstract void keyPressedF();

    public abstract void keyPressedU();

    public abstract void keyPressedW();

    public abstract void keyPressedE();

    public abstract void keyPressed4();

    public abstract void keyPressed6();

    public abstract void keyPressedEnter();

    public abstract void keyPressedSpace();

    public abstract void keyPressedT();

    public abstract void keyPressedC();

    public abstract void keyPressedS();

    public abstract void keyPressedM();

    public abstract void keyPressedJ();

    public abstract void keyPressedK();

    public abstract void keyPressedD();
}
