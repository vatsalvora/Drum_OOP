package model.state;

import model.GameFacade;
import model.Location;

/**
 * Created by devan on 4/9/14.
 */
public class Replay extends State {


    public Replay(GameFacade gameFacade) {
        super(gameFacade);
    }

    @Override
    public void keyPressed4() {
        // TODO: Go back
    }

    @Override
    public void keyPressed6() {
        // TODO: Go forward

    }

    @Override
    public void keyPressedS() {
        commandCreator.save("test.txt");
    }

    @Override
    public void keyPressedR() {
        // TODO: Restart
    }

    @Override
    public void keyPressed1() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressed2() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressed3() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressed7() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressed8() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressed9() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedTab() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedP(Location location) {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedV(Location location) {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedI(Location location) {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedX() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedA() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedESC() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedF() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedU() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedW() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedE() {
        incorrectKeyPressed();
    }
}
