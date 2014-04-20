package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/14/14.
 */
public class KeyPressedU extends KeyPressed {

    public KeyPressedU(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'u'){
            state.keyPressedU();
        }
    }
}
