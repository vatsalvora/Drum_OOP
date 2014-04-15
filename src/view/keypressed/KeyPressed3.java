package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/34/34.
 */
public class KeyPressed3 extends KeyPressed {

    public KeyPressed3(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == '3'){
            state.keyPressed3();
        }
    }
}
