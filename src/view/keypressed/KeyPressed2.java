package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/24/24.
 */
public class KeyPressed2 extends KeyPressed {

    public KeyPressed2(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '2'){
            state.keyPressed2();
        }
    }
}
