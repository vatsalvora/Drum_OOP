package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedJ extends KeyPressed {

    public KeyPressedJ(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'j'){
            state.keyPressedF();
        }
    }
}
