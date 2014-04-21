package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedV extends KeyPressed {

	public KeyPressedV(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 'v') {
			state.keyPressedV();
		}
	}
}
