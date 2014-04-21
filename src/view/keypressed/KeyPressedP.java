package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedP extends KeyPressed {

	public KeyPressedP(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'p') {
			state.keyPressedP();
		}
	}
}
