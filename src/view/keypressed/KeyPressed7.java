package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/74/74.
 */
public class KeyPressed7 extends KeyPressed {

    protected KeyPressed7(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '7'){
            state.keyPressed7();
        }
    }
}
