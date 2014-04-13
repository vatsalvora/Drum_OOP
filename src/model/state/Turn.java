package model.state;


public class Turn extends State {

	@Override
	public void changeCurrentState(State state) {

	}

	@Override
	public void changeState(StateType stateType) {

	}

	@Override
	public StateType getCurrentState() {
		return null;
	}

	@Override
	public void incorrectKeyPressed() {
		// TODO: Buzz buzz
		// TODO: Second thought: should any subclass really override this
		// method?
		// Every wrong key will be handled the same, yeah?
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
	public void keyPressedP() {
		// TODO: Place new Palace
	}

	@Override
	public void keyPressedV() {
	}

	@Override
	public void keyPressedI() {

	}

	@Override
	public void keyPressedX() {
		// TODO: End turn
	}

	@Override
	public void keyPressedA() {

	}

	@Override
	public void keyPressedESC() {

	}

	@Override
	public void keyPressedF() {

	}

	@Override
	public void keyPressedU() {

	}

	@Override
	public void keyPressedW() {

	}

	@Override
	public void keyPressedE() {

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
	public void keyPressedEnter() {
		// TODO: Execute
	}
}
