package model.state;

import model.GameFacade;

/**
 * Created by devan on 4/9/14.
 */
public class Planning extends State {


    public Planning(GameFacade gameFacade) {
        super(gameFacade);
    }
        /* //TODO
Planning
====================
Move selected item SW
Move selected item S
Move selected item SE
Move selected item NE
Move selected item N
Move selected item NW
Select rice tile
place new palace tile
place new village tile
place new irrigation tile
end planning mode
undo last move
     */


	public void keyPressed1() {
		// TODO: Move to SW position
	}

	public void keyPressed2() {
		// TODO: Move to S position
	}

	public void keyPressed3() {
		// TODO: Move to SE position
	}

	public void keyPressed7() {
		// TODO: Move to NE position
	}

	public void keyPressed8() {
		// TODO: Move to N position
	}

	public void keyPressed9() {
		// TODO: Move to NW position
	}

	public void keyPressedTab() {
		// TODO: Tab through developers
	}

	public void keyPressedR() {
		// TODO: Select rice tile
	}

	public void keyPressedP() {
		// TODO: Place new Palace tile

	}

	public void keyPressedV() {

		// TODO: Place new Village tile
	}

	public void keyPressedI() {
		// TODO: Place new Irrigation tile
	}

	public void keyPressedX() {
		// TODO: End planning mode
	}

	public void keyPressedA() {
		// No action
	}

	public void keyPressedESC() {
		// No action
	}

	public void keyPressedF() {
		// No action
	}

	public void keyPressedU() {
		// TODO: Undo last move
	}

	public void keyPressedW() {
		// No action
	}

	public void keyPressedE() {
		// No action
	}

	public void keyPressed4() {
		// No action
	}

	public void keyPressed6() {
		// No action
	}

	public void keyPressedEnter() {
		// Execute moves
	}
}
