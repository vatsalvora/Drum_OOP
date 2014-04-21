package model.state;

import model.GameFacade;
import view.keypressed.KeyPressed;

public class Turn extends State {

    public Turn(GameFacade gameFacade) {
        super(gameFacade);
        super.setCurrentState(StateType.TURN);
    }
    public Turn(){}


    @Override
    public void keyPressedS() {
        commandCreator.save("test.txt");
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

    @Override
    public void keyPressedTab() {
        // TODO: Tab through developers
    }

    @Override
    public void keyPressedR() {
        commandCreator.placeRiceTile();
    }

    @Override
    public void keyPressedP() {
        // defaulting level of palace to 2
        // TODO change level of palace somehow
        commandCreator.placePalaceTile(2);
    }

    @Override
    public void keyPressedV() {
        commandCreator.placeVillageTile();
    }

    @Override
    public void keyPressedI() {
        commandCreator.placeIrrigationTile();
    }

    @Override
    public void keyPressedX() {
        commandCreator.changeTurn();
    }

    @Override
    public void keyPressed4() {
        // TODO: Go back

    }

    @Override
    public void keyPressed6() {
        // TODO: Go forward
        State state = new Replay();
        KeyPressed.setState(state);
    }

    @Override
    public void keyPressedA() {
        commandCreator.placeDoubleLandTile();
    }

    @Override
    public void keyPressedESC() {
        incorrectKeyPressed();
    }

    @Override
    public void keyPressedF() {
        commandCreator.drawFestivalCard();
    }

	@Override
	public void keyPressedU() {
		commandCreator.undoAll();
	}

    @Override
    public void keyPressedW() {
        commandCreator.placeTripleLandTile();
    }

    @Override
    public void keyPressedE() {
        //TODO change level of palace somehow
        commandCreator.upgradePalaceTile(4);
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
        commandCreator.initiatePalaceFestival();
    }

    public void keyPressedJ() {
        commandCreator.removeDeveloper();
    }

    public void keyPressedK() {
        commandCreator.placeDeveloper();
    }

    public void keyPressedD() { commandCreator.selectDeveloper();}

}
