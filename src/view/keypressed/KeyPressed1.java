package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class KeyPressed1 extends KeyPressed {

	public KeyPressed1(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == '1') {
			try {
				state.keyPressed1();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
