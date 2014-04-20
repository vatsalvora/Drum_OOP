package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by Vatsal on 4/20/2014.
 */
public class KeyPressedSpace extends KeyPressed{
    public KeyPressedSpace(State state) {
        super( state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == KeyEvent.VK_SPACE){
            state.keyPressedSpace();
        }
    }
}
