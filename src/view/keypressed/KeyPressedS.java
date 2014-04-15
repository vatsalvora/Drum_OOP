package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/S4/S4.
 */
public class KeyPressedS extends KeyPressed {

    public KeyPressedS(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 's'){
            state.keyPressedS();
        }
    }
}
