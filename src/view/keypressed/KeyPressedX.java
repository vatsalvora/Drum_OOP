package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/X4/X4.
 */
public class KeyPressedX extends KeyPressed {

    public KeyPressedX(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'x'){
            state.keyPressedX();
        }
    }
}
