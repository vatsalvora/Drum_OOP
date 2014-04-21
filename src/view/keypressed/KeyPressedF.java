package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedF extends KeyPressed {

	public KeyPressedF(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'f') {
			state.keyPressedF();
		}
	}
}
