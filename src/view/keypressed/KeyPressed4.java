package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/44/44.
 */
public class KeyPressed4 extends KeyPressed {

    public KeyPressed4(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '4'){
            state.keyPressed4();
        }
    }
}
