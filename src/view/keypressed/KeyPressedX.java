package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedX extends KeyPressed {

	public KeyPressedX(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'x') {
			state.keyPressedX();
		}
	}
}
