package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/a4/a4.
 */
public class KeyPressedA extends KeyPressed {

    public KeyPressedA(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'a'){
            state.keyPressedA();
        }
    }
}
