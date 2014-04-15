package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/I4/I4.
 */
public class KeyPressedI extends KeyPressed {

    public KeyPressedI(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'i'){
            state.keyPressedI(location);
        }
    }
}
