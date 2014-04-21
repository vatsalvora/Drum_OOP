package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedD extends KeyPressed {

    public KeyPressedD(State state) {
        super(state);
    }

    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'd'){
            state.keyPressedD();
        }
    }
}
