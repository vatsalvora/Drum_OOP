package model;

import controller.BoardController;
import controller.SharedResourcesController;
import controller.TurnController;
import model.customExceptions.BlockNotPlayedException;
import model.customExceptions.NoIrrigationLeftException;

public class GameFacade {
	BoardController boardController;
	TurnController turnController;
	SharedResourcesController sharedResourcesController;

	public GameFacade(String[] player) {
		turnController = new TurnController(player);
		boardController = new BoardController();
		sharedResourcesController = new SharedResourcesController();
	}

	public void placeIrrigationTile(Location location) {
        try
        {
            sharedResourcesController.placeIrrigationTile();
            try
            {
                //place the irrigation at the proper spot
            }
            catch(Exception e)
            {
                //return irrigation tile
            }
        }
        catch(NoIrrigationLeftException e)
        {
            //possibly do something with the exception, such as print it to the user
        }
	}

	public void placeVillageTile(Location location) {
	}

	public void placeRiceTile(Location location) {
	}

	public void placeDoubleLandTile(Location location) {
	}

	public void placeTripleLandTile(Location location) {
	}

	public void initiatePalaceFestival() {
	}

	public void placePalaceTile(Location l) {
		// TODO Auto-generated method stub

	}

	public void changeTurn() throws BlockNotPlayedException {
		turnController.nextTurn();
	}

	public void endPalaceFestival() {

	}

}
