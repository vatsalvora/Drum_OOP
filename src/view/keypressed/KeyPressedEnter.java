package view.keypressed;

import model.state.State;
import java.awt.event.KeyEvent;

public class KeyPressedEnter extends KeyPressed {

	public KeyPressedEnter(State state) {
		super(state);
	}

	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
			state.keyPressedEnter();
		}
	}

}
