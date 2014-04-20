package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/X4/X4.
 */
public class KeyPressedD extends KeyPressed {

    public KeyPressedD(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'd'){
            state.keyPressedD();
        }
    }
}
