package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedS extends KeyPressed {

	public KeyPressedS(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == 's') {
			state.keyPressedS();
			System.out.println("Key listener for s is working");
		}

	}
}
