package model.state;

import model.GameFacade;
import model.Location;
import model.commands.CommandCreator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by devan on 4/9/14.
 */
public abstract class State {

	static CommandCreator commandCreator;
	private StateType stateType;
	private final static Logger LOGGER = Logger.getLogger(State.class.getName());

	public State(GameFacade gameFacade) {
		commandCreator = new CommandCreator(gameFacade);
	}

	public void incorrectKeyPressed() {
		java.awt.Toolkit.getDefaultToolkit().beep();
		LOGGER.log(Level.WARNING, "Incorrect key pressed");
	}

	public abstract void keyPressed1();

	public abstract void keyPressed2();

	public abstract void keyPressed3();

	public abstract void keyPressed7();

	public abstract void keyPressed8();

	public abstract void keyPressed9();

	public abstract void keyPressedTab();

	public abstract void keyPressedR();

	public abstract void keyPressedP(Location location);

	public abstract void keyPressedV(Location location);

	public abstract void keyPressedI(Location location);

	public abstract void keyPressedX();

	public abstract void keyPressedA();

	public abstract void keyPressedESC();

	public abstract void keyPressedF();

	public abstract void keyPressedU();

	public abstract void keyPressedW();

	public abstract void keyPressedE();

	public abstract void keyPressed4();

	public abstract void keyPressed6();

	public StateType getCurrentState() {
		return this.stateType;
	}

	public void setCurrentState(StateType current) {
		stateType = current;
	}

	public abstract void keyPressedS();
}
