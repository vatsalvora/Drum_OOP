package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedESC extends KeyPressed {

	public KeyPressedESC(State state) {
		super(state);
	}

	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
			state.keyPressedESC();
		}
	}
}
