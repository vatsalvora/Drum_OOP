package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/W4/W4.
 */
public class KeyPressedW extends KeyPressed {

    public KeyPressedW(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'w'){
            state.keyPressedW();
        }
    }
}
