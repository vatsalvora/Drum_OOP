package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedTab extends KeyPressed {

	public KeyPressedTab(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_TAB) {
			state.keyPressedTab();
		}
	}
}
