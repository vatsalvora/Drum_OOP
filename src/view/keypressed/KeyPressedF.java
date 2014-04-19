package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/F4/F4.
 */
public class KeyPressedF extends KeyPressed {

    public KeyPressedF(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'f'){
            state.keyPressedF();
        }
    }
}
