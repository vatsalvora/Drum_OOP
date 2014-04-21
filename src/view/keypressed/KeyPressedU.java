package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedU extends KeyPressed {

	public KeyPressedU(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'u') {
			state.keyPressedU();
		}
	}
}
