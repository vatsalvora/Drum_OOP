package model.state;

import model.GameFacade;

/**
 * Created by devan on 4/9/14.
 */
public class Festival extends State {

	public Festival() {
        super();
        gameFacade.sendErrorMessage("Palace Festival");
        gameFacade.render();
	}


	@Override
	public void keyPressed1() {

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
		commandCreator.initiatePalaceFestival();
	}

	@Override
	public void keyPressedX() {

	}

	@Override
	public void keyPressedA() {

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
	public void keyPressedS() {

	}

	@Override
	public void keyPressedEnter() {
		incorrectKeyPressed();
	}
    @Override
    public void keyPressedSpace() {
        incorrectKeyPressed();
    }

    public void keyPressedT() { incorrectKeyPressed();}

    public void keyPressedC() { incorrectKeyPressed();}

    public void keyPressedM() { incorrectKeyPressed();}

    public void keyPressedJ() { incorrectKeyPressed();}

    public void keyPressedK() { incorrectKeyPressed();}

    public void keyPressedD() { incorrectKeyPressed();}
}
