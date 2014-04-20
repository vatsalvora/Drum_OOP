package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/E4/E4.
 */
public class KeyPressedE extends KeyPressed {

    public KeyPressedE(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'e'){
            state.keyPressedE();
        }
    }
}
