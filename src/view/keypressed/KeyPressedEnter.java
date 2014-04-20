package view.keypressed;

import model.state.State;

import java.awt.event.KeyEvent;

/**
 * Created by Vatsal on 4/19/2014.
 */
public class KeyPressedEnter extends KeyPressed{

    public KeyPressedEnter(State state) {
        super(state);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyChar() == KeyEvent.VK_ENTER){
            state.keyPressedEnter();
        }
    }

}
