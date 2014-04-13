package model.state;

import model.CommandCreator;
import model.GameFacade;

/**
 * Created by devan on 4/9/14.
 */
public class Start extends State {

	public Start(GameFacade gameFacade) {
		commandCreator = new CommandCreator(gameFacade);
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
    public void keyPressedR() {
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
        incorrectKeyPressed();
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
    public void keyPressed4() {
        incorrectKeyPressed();
    }

	@Override
	public void keyPressed6() {
        incorrectKeyPressed();
	}

	@Override
	public void keyPressedEnter() {
		// TODO: Create a new game

	}
}
