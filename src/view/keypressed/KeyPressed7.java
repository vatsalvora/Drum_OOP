package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressed7 extends KeyPressed {

    public KeyPressed7(State state) {
        super(state);
    }

    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '7'){
            state.keyPressed7();
        }
    }
}
