package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/a4/a4.
 */
public class KeyPressedA extends KeyPressed {

    protected KeyPressedA(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'a'){
            state.keyPressedA();
        }
    }
}
