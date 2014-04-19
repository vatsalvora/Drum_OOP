package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/14/14.
 */
public class KeyPressedP extends KeyPressed {

    public KeyPressedP(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'p'){
            state.keyPressedP();
        }
    }
}
