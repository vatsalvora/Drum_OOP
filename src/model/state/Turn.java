package model.state;

import model.GameFacade;
import model.Location;

public class Turn extends State {

	public Turn(GameFacade gameFacade) {
		super(gameFacade);
		super.setCurrentState(StateType.TURN);
	}

	/*
	 * TURN ========== placePalace(location) placeVillageTile(location) execute
	 * //??
	 */

	// @Override
	// public void changeCurrentState(State state) {
	//
	// }
	//
	// @Override
	// public void changeState(StateType stateType) {
	//
	// }

	@Override
	public StateType getCurrentState() {
		return null;
	}

	@Override
	public void keyPressedS() {
		commandCreator.save("test.txt");
	}

	@Override
	public void keyPressed1() {
		commandCreator.move1();
	}

	@Override
	public void keyPressed2() {
        commandCreator.move2();
	}

	@Override
	public void keyPressed3() {
		commandCreator.move3();
	}

	@Override
	public void keyPressed7() {
		commandCreator.move7();
	}

	@Override
	public void keyPressed8() {
		commandCreator.move8();
	}

	@Override
	public void keyPressed9() {
		commandCreator.move9();
	}

	@Override
	public void keyPressedTab() {
		// TODO: Tab through developers
	}

	@Override
	public void keyPressedR() {
		commandCreator.placeRiceTile();
	}

	@Override
	public void keyPressedP() {
		// defaulting level of palace to 2
		// TODO change level of palace somehow
		commandCreator.placePalaceTile(2);
	}

	@Override
	public void keyPressedV() {
		commandCreator.placeVillageTile();
	}

	@Override
	public void keyPressedI() {
		commandCreator.placeIrrigationTile();
	}

	@Override
	public void keyPressedX() {
		commandCreator.changeTurn();
	}

	@Override
	public void keyPressed4() {
		// TODO: Go back
	}

	@Override
	public void keyPressed6() {
		// TODO: Go forward

	}

	@Override
	public void keyPressedA() {
		commandCreator.placeDoubleLandTile();
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
		commandCreator.placeTripleLandTile();
	}

	@Override
	public void keyPressedE() {
		incorrectKeyPressed();
	}

	@Override
	public void keyPressedEnter() {
		commandCreator.execute();
	}

    @Override
    public void keyPressedSpace() {
       commandCreator.rotate();
    }


}
