package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/V4/V4.
 */
public class KeyPressedV extends KeyPressed {

    public KeyPressedV(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'v'){
            state.keyPressedV();
        }
    }
}
