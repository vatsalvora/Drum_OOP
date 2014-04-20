package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/S4/S4.
 */
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
