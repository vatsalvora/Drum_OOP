package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedA extends KeyPressed {

	public KeyPressedA(State state) {
		super(state);
	}

	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'a') {
			state.keyPressedA();
		}
	}
}
