package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedK extends KeyPressed {

    public KeyPressedK(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'k'){
            state.keyPressedF();
        }
    }
}
