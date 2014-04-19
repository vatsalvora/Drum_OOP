package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/14/14.
 */
public class KeyPressed1 extends KeyPressed {

    public KeyPressed1(State state) {
        super( state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '1'){
            state.keyPressed1();
        }
    }
}
