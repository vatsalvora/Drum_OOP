package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;


public class KeyPressedE extends KeyPressed {

	public KeyPressedE(State state) {
		super(state);
	}

	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'e') {
			state.keyPressedE();
		}
	}
}
