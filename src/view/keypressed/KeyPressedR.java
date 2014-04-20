package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/R4/R4.
 */
public class KeyPressedR extends KeyPressed {

    public KeyPressedR(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'r'){
            state.keyPressedR();
        }
    }
}
