package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;


public class KeyPressed9 extends KeyPressed {

    public KeyPressed9(State state) {
        super(state);
    }

    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '9'){
            state.keyPressed9();
        }
    }
}
