package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/94/94.
 */
public class KeyPressed9 extends KeyPressed {

    public KeyPressed9(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '9'){
            state.keyPressed9();
        }
    }
}
