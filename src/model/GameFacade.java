package model;

public class GameFacade {
	BoardController boardController;
	TurnController turnController;
	SharedResourcesController sharedResourcesController;

	public GameFacade(String[] player) {
		turnController = new TurnController(player);
		boardController = new BoardController(new Board());
		sharedResourcesController = new SharedResourcesController();
	}

	public void placeIrrigationTile(Location location) {
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

	public void changeTurn() {
		turnController.nextTurn();
	}

	public void endPalaceFestival() {

	}

}
