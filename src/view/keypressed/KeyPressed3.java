package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

public class KeyPressed3 extends KeyPressed {

    public KeyPressed3(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '3'){
            state.keyPressed3();
        }
    }
}
