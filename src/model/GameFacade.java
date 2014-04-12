package model;

import java.util.List;

public class GameFacade {
	BoardController b;
	TurnController t;

	GameFacade(BoardController b, TurnController t) {
		this.b = b;
		this.t = t;
	}

	GameFacade(List<Player> p) {
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

}
