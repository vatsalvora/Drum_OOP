package model;

/**
 * Created by devan on 4/9/14.
 */
public class Planning implements State {

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
		// TODO: Buzz, no other action
    }

    @Override
    public void keyPressed1() {
		// TODO: Move to SW position
    }

    @Override
    public void keyPressed2() {
		// TODO: Move to S position
    }

    @Override
    public void keyPressed3() {
		// TODO: Move to SE position
    }

    @Override
    public void keyPressed7() {
		// TODO: Move to NE position
    }

    @Override
    public void keyPressed8() {
		// TODO: Move to N position
    }

    @Override
    public void keyPressed9() {
		// TODO: Move to NW position
    }

    @Override
    public void keyPressedTab() {	
		// TODO: Tab through developers
    }

    @Override
    public void keyPressedR() {
		// TODO: Select rice tile
    }

    @Override
    public void keyPressedP() {
		// TODO: Place new Palace tile
    }

    @Override
    public void keyPressedV() {
		// TODO: Place new Village tile
    }

    @Override
    public void keyPressedI() {
		// TODO: Place new Irrigation tile
    }

    @Override
    public void keyPressedX() {
		// TODO: End planning mode
    }

    @Override
    public void keyPressedA() {
		// No action
    }

    @Override
    public void keyPressedESC() {
		// No action
    }

    @Override
    public void keyPressedF() {
		// No action
    }

    @Override
    public void keyPressedU() {
		// TODO: Undo last move	
    }

    @Override
    public void keyPressedW() {
		// No action
    }

    @Override
    public void keyPressedE() {
		// No action
    }

    @Override
    public void keyPressed4() {
		// No action
    }

    @Override
    public void keyPressed6() {
		// No action
    }

    @Override
    public void keyPressedEnter() {
		// Execute moves
    }
}
