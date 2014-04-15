package view.keypressed;

import model.Location;
import model.state.State;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by devan on 4/14/14.
 */
public abstract class KeyPressed extends KeyAdapter {
    protected Location location;
    protected State state;

    protected KeyPressed(Location location, State state) {
        this.location = location;
    }

    public abstract void keyTyped(KeyEvent ke);


    public void keyPressed(KeyEvent ke) {

    }

    public void keyReleased(KeyEvent ke) {

    }

}
