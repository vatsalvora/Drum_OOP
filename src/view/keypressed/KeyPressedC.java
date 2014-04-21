package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedC extends KeyPressed {

	public KeyPressedC(State state) {
		super(state);
	}

	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'c') {
			state.keyPressedC();
		}
	}
}
