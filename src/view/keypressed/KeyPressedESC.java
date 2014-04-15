package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/ESC4/ESC4.
 */
public class KeyPressedESC extends KeyPressed {

    public KeyPressedESC(Location location, State state) {
        super(location, state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_ESCAPE){
            state.keyPressedESC();
        }
    }
}
