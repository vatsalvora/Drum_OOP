package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/24/24.
 */
public class KeyPressed2 extends KeyPressed {

	public KeyPressed2(State state) {
		super(state);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == '2') {
			state.keyPressed2();
		}
	}
}
