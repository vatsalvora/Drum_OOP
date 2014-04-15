package model.state;

import model.GameFacade;
import model.Location;

/**
 * Created by devan on 4/9/14.
 */
public class Planning extends State {


    public Planning(GameFacade gameFacade) {
        super(gameFacade);
    }

    public void keyPressed1() {
        // TODO: Move to SW position
    }

    public void keyPressed2() {
        // TODO: Move to S position
    }

    public void keyPressed3() {
        // TODO: Move to SE position
    }

    public void keyPressed7() {
        // TODO: Move to NE position
    }

    public void keyPressed8() {
        // TODO: Move to N position
    }

    public void keyPressed9() {
        // TODO: Move to NW position
    }

    public void keyPressedTab() {
        // TODO: Tab through developers
    }

    public void keyPressedR() {
        // TODO: Select rice tile
    }

    @Override
    public void keyPressedP(Location location) {
        commandCreator.placePalaceTile(location);
    }

    @Override
    public void keyPressedV(Location location) {
        commandCreator.placeVillageTile(location);
    }

    @Override
    public void keyPressedI(Location location) {
        commandCreator.placeIrrigationTile(location);
    }


    public void keyPressedU() {
        commandCreator.undoLastCommand();
    }

    public void keyPressedX() {
        // TODO: End planning mode
    }

    public void keyPressedA() {
        incorrectKeyPressed();
    }

    public void keyPressedESC() {
        incorrectKeyPressed();
    }

    public void keyPressedF() {
        incorrectKeyPressed();
    }

    public void keyPressedW() {
        incorrectKeyPressed();
    }

    public void keyPressedE() {
        incorrectKeyPressed();
    }

    public void keyPressed4() {
        incorrectKeyPressed();
    }

    public void keyPressed6() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedS() {

    }
}
