package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressedM extends KeyPressed {

    public KeyPressedM(State state) {
        super( state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == 'm'){
            state.keyPressedM();
        }
    }
}
