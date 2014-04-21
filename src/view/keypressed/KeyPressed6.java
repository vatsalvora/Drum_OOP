package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressed6 extends KeyPressed {

	public KeyPressed6(State state) {
		super(state);
	}

	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == '6') {
			state.keyPressed6();
		}
	}
}
