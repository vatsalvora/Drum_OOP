package model.state;

import model.GameFacade;
import view.keypressed.KeyPressed;

/**
 * Created by devan on 4/9/14.
 */
public class Planning extends State {


    public Planning(){
         commandCreator.setPlanning(true);
    }

    @Override
    public void keyPressed1() {
        commandCreator.move1();
    }

    @Override
    public void keyPressed2() {
        commandCreator.move2();
    }

    @Override
    public void keyPressed3() {
        commandCreator.move3();
    }

    @Override
    public void keyPressed7() {
        commandCreator.move7();
    }

    @Override
    public void keyPressed8() {
        commandCreator.move8();
    }

    @Override
    public void keyPressed9() {
        commandCreator.move9();
    }
    public void keyPressedTab() {
        // TODO: Tab through developers
    }

    public void keyPressedR() {
        // TODO: Select rice tile
    }

    @Override
    public void keyPressedP() {
        //defaulting level of palace to 2
        //TODO change level of palace somehow
        commandCreator.placePalaceTile();
    }

    @Override
    public void keyPressedV() {
        commandCreator.placeVillageTile();
    }

    @Override
    public void keyPressedI() {
        commandCreator.placeIrrigationTile();
    }

    public void keyPressedU() {

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
        commandCreator.setPlanning(false);
        State s = new Turn();
        KeyPressed.setState(s);
        commandCreator.tossPlan();
    }

    public void keyPressedE() {
        //TODO change level of palace somehow
        commandCreator.upgradePalaceTile();
    }

    public void keyPressed4() {

    }

    public void keyPressed6() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedS() {

    }

    @Override
    public void keyPressedEnter() {
        commandCreator.execute();
    }

    @Override
    public void keyPressedSpace() {
        commandCreator.rotate();
    }

    public void keyPressedT() {
        commandCreator.useActionToken();
    }

    public void keyPressedC() {
        commandCreator.drawCard();
    }

    public void keyPressedM() {

        commandCreator.setPlanning(false);
        State s = new Turn();
        KeyPressed.setState(s);
        commandCreator.usePlan();
    }

    public void keyPressedJ() {
        commandCreator.removeDeveloper();
    }

    public void keyPressedK() {
        commandCreator.placeDeveloper();
    }

    public void keyPressedD() { commandCreator.selectDeveloper();}


}
