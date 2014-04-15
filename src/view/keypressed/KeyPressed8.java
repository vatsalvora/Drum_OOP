package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/84/84.
 */
public class KeyPressed8 extends KeyPressed {

    public KeyPressed8(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '8'){
            state.keyPressed8();
        }
    }
}
