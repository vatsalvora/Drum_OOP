package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedW extends KeyPressed {

	public KeyPressedW(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'w') {
			state.keyPressedW();
		}
	}
}
