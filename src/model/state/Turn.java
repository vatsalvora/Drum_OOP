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
		// TODO: Move to SW
	}

	@Override
	public void keyPressed2() {
		// TODO: Move to S
	}

	@Override
	public void keyPressed3() {
		// TODO: Move to SE
	}

	@Override
	public void keyPressed7() {
		// TODO: Move to NE
	}

	@Override
	public void keyPressed8() {
		// TODO: Move to N
	}

	@Override
	public void keyPressed9() {
		// TODO: Move to NW
	}

	@Override
	public void keyPressedTab() {
		// TODO: Tab through developers
	}

	@Override
	public void keyPressedR() {
		// TODO: Select Rice tile
	}

	@Override
	public void keyPressedP(Location location) {
		commandCreator.placePalaceTile(location);
	}

	@Override
	public void keyPressedV(Location location) {
		commandCreator.placeVillageTile(location);
	}

	@Override
	public void keyPressedI(Location location) {
		commandCreator.placeIrrigationTile(location);
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
    public void keyPressedEnter() { incorrectKeyPressed();}
}
