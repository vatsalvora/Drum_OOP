package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/Tab4/Tab4.
 */
public class KeyPressedTab extends KeyPressed {

    public KeyPressedTab(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_TAB){
            state.keyPressedTab();
        }
    }
}
