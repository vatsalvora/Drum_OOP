package model.state;

import model.GameFacade;
import view.keypressed.KeyPressed;

/**
 * Created by devan on 4/9/14.
 */
public class Replay extends State {

	public Replay(GameFacade gameFacade) {
		super(gameFacade);
	}

	public Replay() {
	}

	@Override
	public void keyPressed4() {
		commandCreator.undoLastCommand();
	}

	@Override
	public void keyPressed6() {
		commandCreator.redoLastCommand();
	}

	@Override
	public void keyPressedS() {
		commandCreator.save("test.txt");
	}

	@Override
	public void keyPressedR() {
		commandCreator.restart();
	}

	@Override
	public void keyPressed1() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressed2() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressed3() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressed7() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressed8() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressed9() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedTab() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedP() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedV() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedI() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedX() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedA() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedESC() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedF() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedU() {
		commandCreator.undoAll();
	}

	@Override
	public void keyPressedW() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedE() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedEnter() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedSpace() {
		incorrectKeyPressed();
	}

	public void keyPressedT() {
		State t = new Turn();
		KeyPressed.setState(t);
	}

	public void keyPressedC() {
		incorrectKeyPressed();
	}

	public void keyPressedM() {
		incorrectKeyPressed();
	}

	public void keyPressedJ() {
		commandCreator.redoLastCommand();
	}

	public void keyPressedK() {
		commandCreator.undoLastCommand();
	}

	public void keyPressedD() {
		incorrectKeyPressed();
	}
}
