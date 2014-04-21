package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;


public class KeyPressed4 extends KeyPressed {

    public KeyPressed4(State state) {
        super(state);
    }

    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '4'){
            state.keyPressed4();
        }
    }
}
