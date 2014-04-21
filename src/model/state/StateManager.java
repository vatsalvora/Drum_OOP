package model.state;

import java.util.ArrayList;
import java.util.List;

import view.keypressed.KeyPressed;
import view.keypressed.KeyPressed1;
import view.keypressed.KeyPressed2;
import view.keypressed.KeyPressed3;
import view.keypressed.KeyPressed4;
import view.keypressed.KeyPressed6;
import view.keypressed.KeyPressed7;
import view.keypressed.KeyPressed8;
import view.keypressed.KeyPressed9;
import view.keypressed.KeyPressedA;
import view.keypressed.KeyPressedC;
import view.keypressed.KeyPressedD;
import view.keypressed.KeyPressedE;
import view.keypressed.KeyPressedESC;
import view.keypressed.KeyPressedEnter;
import view.keypressed.KeyPressedF;
import view.keypressed.KeyPressedI;
import view.keypressed.KeyPressedJ;
import view.keypressed.KeyPressedK;
import view.keypressed.KeyPressedM;
import view.keypressed.KeyPressedP;
import view.keypressed.KeyPressedR;
import view.keypressed.KeyPressedS;
import view.keypressed.KeyPressedSpace;
import view.keypressed.KeyPressedT;
import view.keypressed.KeyPressedTab;
import view.keypressed.KeyPressedU;
import view.keypressed.KeyPressedV;
import view.keypressed.KeyPressedW;
import view.keypressed.KeyPressedX;
import model.GameFacade;
import model.Location;

public class StateManager {
	GameFacade b;
	public State states[];
	static State current;

	public StateManager() {
		State states[] = { new Turn(), new Planning(), new Replay() };
		current = states[0];
		
	}

	public void changeState(int i) {
		current = states[i];
	}

}
