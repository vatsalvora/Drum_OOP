package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedI extends KeyPressed {

	public KeyPressedI(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'i') {
			state.keyPressedI();
		}
	}
}
