package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/64/64.
 */
public class KeyPressed6 extends KeyPressed {

    public KeyPressed6(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '6'){
            state.keyPressed6();
        }
    }
}
