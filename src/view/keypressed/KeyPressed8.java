package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressed8 extends KeyPressed {

    public KeyPressed8(State state) {
        super(state);
    }

    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '8'){
            state.keyPressed8();
        }
    }
}
