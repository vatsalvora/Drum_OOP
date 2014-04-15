package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/64/64.
 */
public class KeyPressed6 extends KeyPressed {

    public KeyPressed6(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '6'){
            state.keyPressed6();
        }
    }
}
