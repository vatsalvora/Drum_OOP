package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedT extends KeyPressed {

    public KeyPressedT(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 't'){
            state.keyPressedT();
        }
    }
}
