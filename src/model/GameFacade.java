package model;

public class GameFacade {
	BoardController b;
	TurnController t;
	SharedResourcesController s;

	public GameFacade(String[] player) {
		t = new TurnController(player);
		b = new BoardController(new Board());
		s = new SharedResourcesController();
	}

	public void placeIrrigationTile(Location l) {
	}

	public void placeVillageTile(Location l) {
	}

	public void placeRiceTile(Location l) {
	}

	public void placeDoubleLandTile(Location l) {
	}

	public void placeTripleLandTile(Location l) {
	}

	public void initiatePalaceFestival() {
	}

	public void changeTurn() {
		t.nextTurn();
	}

	public void endPalaceFestival() {

	}

}
