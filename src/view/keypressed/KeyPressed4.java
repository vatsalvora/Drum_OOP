package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/44/44.
 */
public class KeyPressed4 extends KeyPressed {

    protected KeyPressed4(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '4'){
            state.keyPressed4();
        }
    }
}
