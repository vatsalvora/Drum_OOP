package model;

import controller.AreaViewportController;
import controller.BoardController;
import controller.SharedResourcesController;
import controller.TurnController;
import model.customExceptions.*;
import test.FestivalTest;
import view.keypressed.KeyPressed;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameFacade {
	private BoardController boardController;
	private TurnController turnController;
	private SharedResourcesController sharedResourcesController;
	private AreaViewportController areaViewportController;
	private Color cornflower_blue = new Color(100, 149, 237);

	public GameFacade(String[] player) {
		turnController = new TurnController(player);
		boardController = new BoardController();
		sharedResourcesController = new SharedResourcesController(turnController);
		areaViewportController = new AreaViewportController(boardController.getBoard());
		startGame();
	}

	public void addKeyListeners(List<KeyPressed> keySet) {
		areaViewportController.addListeners(keySet);
	}

	public void render() {
		areaViewportController.render(boardController.getBoard());
		sharedResourcesController.render();
	}

	public void startGame() {
		for (Player p : turnController.getPlayers()) {
			p.addCard(sharedResourcesController.drawCard());
			p.addCard(sharedResourcesController.drawCard());
			p.addCard(sharedResourcesController.drawCard());
		}
		turnController.putFestivalCard(sharedResourcesController.drawCard());
		sharedResourcesController.render();
	}

	public void setMovementColor(Color color) {
		areaViewportController.setMovementColor(color);
	}

	public void setRotation(int[] rotation) {
		boardController.setRotations(rotation);
	};

	public Player[] getPlayers() {
		return turnController.getPlayers();
	}

	public Player getCurrentPlayer() {
		return turnController.getCurrentPlayer();
	}

	public Board getBoard() {
		return boardController.getBoard();
	}

	public HexSpace getCurrentSpace() {
		return boardController.getCurrentSpace();
	}

	public int getAPLeft() {
		return turnController.APLeft();
	}

	public String currentPlayerName() {
		return turnController.getPlayerName();
	}

	public ArrayList<PalaceCard> currentPlayerCards() {
		return turnController.getCurrentCards();
	}

	public void sendErrorMessage(String s) {
		// send the error message to the view
		sharedResourcesController.sendErrorMessage(s);
		System.out.println(s);
	}

	public void placeOtherBlock() throws NotEnoughAPException {
		turnController.placeOtherBlock();
	}

	public void returnOtherBlock() {
		turnController.returnOtherBlock();
	}

	public void pullIrrigationTile() throws NoIrrigationLeftException {
		sharedResourcesController.placeIrrigationTile();
	}

	public void returnIrrigationTile() {
		sharedResourcesController.returnIrrigationTile();
	}

	public int placeIrrigationTile() throws Exception {
		try {
			// place the village at the proper spot
			// give player the proper points (if applicable)
			HexSpace current = boardController.getCurrentSpace();
			Tile t = new IrrigationTile(0);
			boardController.placeTile(t);
			setMovementColor(cornflower_blue);
			setDevColor(cornflower_blue);
			render();
		} catch (Exception e) {
			// tell user about error
		}
		return 0;
	}

	public void removeIrrigationTile(int i) {
		// take the irrigation tile off of the board
		turnController.decrementFamePoints(i);
	}

	public void undoIrrigationTile(int i) {
		sharedResourcesController.returnIrrigationTile();
		turnController.returnOtherBlock();
		removeIrrigationTile(i);
		boardController.undoTilePlacement();
	}

	public int placeVillageTile() {

		try {
			// place the village at the proper spot
			// give player the proper points (if applicable)
			HexSpace current = boardController.getCurrentSpace();
			Tile t = new VillageTile(0);
			boardController.placeTile(t);

			setMovementColor(cornflower_blue);
			setDevColor(cornflower_blue);
			render();
		} catch (Exception e) {
			// tell user about error
		}
		return 0;

	}

	public void pullVillageTile() throws Exception {
		turnController.placeVillageBlock();
	}

	public void returnVillageTile() {
		turnController.returnVillageBlock();
	}

	public void undoVillageTile(int i) {
		turnController.returnVillageBlock();
		// remove the village tile from the location it was placed
		boardController.undoTilePlacement();
		turnController.decrementFamePoints(i);
	}

	public void setPalaceLvl(int lvl) {
		areaViewportController.setPalaceLvl(lvl);
	}

	public int getPalaceLvl() {
		return areaViewportController.getPalaceLvl();
	}

	public int placeRiceTile() throws Exception {
		try {
			// place the village at the proper spot
			// give player the proper points (if applicable)
			HexSpace current = boardController.getCurrentSpace();
			Tile t = new RiceTile(0, "blah");
			boardController.placeTile(t);
			setMovementColor(cornflower_blue);
			setDevColor(cornflower_blue);
			render();
		} catch (Exception e) {
			// tell user about error
		}
		return 0;
	}

	public void renderPath(List<Space> path) {
		areaViewportController.render(getBoard(), path);
	}

	public void resetView() {
		setMovementColor(cornflower_blue);
		setDevColor(cornflower_blue);
		setPalaceLvl(0);
		setRotation(new int[0]);
		render();
	}

	public void pullRiceTile() throws Exception {
		turnController.placeRiceBlock();
	}

	public void returnRiceTile() {
		turnController.returnRiceBlock();
	}

	public void undoRiceTile(int i) {
		turnController.returnRiceBlock();
		// remove the rice tile from the location it was placed
		boardController.undoTilePlacement();
		turnController.decrementFamePoints(i);
	}

	public int placeTwoBlock() throws Exception {
		HexSpace current = boardController.getCurrentSpace();
		int[] rotations = boardController.getRotations();
		VillageTile village = new VillageTile(1);
		int[] dir = { 0, 1, 2, 5, 4, 3 };

		RiceTile rice = new RiceTile(1, "blah");
		village.createReff(rice, dir[rotations[0]]);
		rice.createReff(village, 5 - dir[rotations[0]]);

		boardController.placeTile(village);

		/*
		 * here i will create the references Tile t = new VillageTile(0);
		 * boardController.placeTile(t);
		 */
		setRotation(new int[0]);
		setMovementColor(cornflower_blue);
		setDevColor(cornflower_blue);
		render();
		// place the village tile on the board
		// give the player the appropriate points and return them
		return 0;
	}

	public void pullTwoBlock() throws Exception {
		turnController.placeTwoBlock();
	}

	public void returnTwoBlock() {
		turnController.returnTwoBlock();
	}

	public void undoTwoBlock(int i) {
		turnController.returnTwoBlock();
		// remove the two block from the location it was placed
		boardController.undoTilePlacement();
		turnController.decrementFamePoints(i);
	}

	public void undoDoubleLandTile() {
		turnController.returnTwoBlock();
		// remove the two block from the location it was placed
		// remove fame points if applicable
	}

	public void pullThreeBlock() throws NoThreeBlockLeftException {
		sharedResourcesController.placeThreeBlock();
	}

	public void returnThreeBlock() {
		sharedResourcesController.returnThreeBlock();
	}

	public int placeThreeBlock() throws Exception {
		HexSpace current = boardController.getCurrentSpace();
		int[] rotations = boardController.getRotations();

		VillageTile village = new VillageTile(2);
		RiceTile rice = new RiceTile(2, "rice1");
		RiceTile rice2 = new RiceTile(2, "rice2");
		int[] dir = { 0, 1, 2, 5, 4, 3 };
		int[] r1Tor2 = { 3, 0, 1, 4, 5, 2 };
		int[] r2Tor1 = { 1, 2, 5, 0, 3, 4 };
		village.createReff(rice, dir[rotations[0]]);
		village.createReff(rice2, dir[rotations[1]]);

		rice.createReff(village, 5 - dir[rotations[0]]);
		rice.createReff(rice2, r1Tor2[5 - dir[rotations[0]]]);

		rice2.createReff(village, 5 - dir[rotations[1]]);
		rice2.createReff(rice, r2Tor1[5 - dir[rotations[1]]]);

		boardController.placeTile(village);

		/*
		 * here i will create the references Tile t = new VillageTile(0);
		 * boardController.placeTile(t);
		 */
		setRotation(new int[0]);
		setMovementColor(cornflower_blue);
		setDevColor(cornflower_blue);
		render();
		// place the village tile on the board
		// give the player the appropriate points and return them
		return 0;

	}

	public void removeThreeBlock(int i) {
		// take the three block off of the board
		turnController.decrementFamePoints(i);
	}

	public void undoThreeBlock(int i) {
		sharedResourcesController.returnThreeBlock();
		turnController.returnOtherBlock();
		removeThreeBlock(i);
		boardController.undoTilePlacement();
	}

	public void initiatePalaceFestival() {
		String[] colors = {};
		// Get valid colors from the board to turn in to festivals
		// turnController.startFestival(colors);
		FestivalTest festival = new FestivalTest();
		festival.PerformFestival(turnController, sharedResourcesController.getDeck());
	}

	public int placePalaceTile(int level) throws Exception {

		Tile t = new PalaceTile(level);
		HexSpace current = boardController.getCurrentSpace();
		System.out.println("YO!");
		if (current.checkPalaceNeighbor(current) < level)
			throw new IncorrectPalaceHeight();
		boardController.placeTile(t);
		setMovementColor(cornflower_blue);
		setDevColor(cornflower_blue);
		setPalaceLvl(0);
		// return fame points gained by palace placement
		return 0;
	}

	/*
	 * try { sharedResourcesController.placePalace(level); try {
	 * turnController.placeOtherBlock(); try { // place the palace at the proper
	 * spot // give fame points to proper player Tile t = new PalaceTile(0);
	 * HexSpace current = boardController.getCurrentSpace();
	 * boardController.placeTile(t); setMovementColor(cornflower_blue);
	 * setDevColor(cornflower_blue);
	 * 
	 * } catch (Exception e) { sharedResourcesController.returnPalace(level); //
	 * tell user about error } } catch (NotEnoughAPException e) { // tell user
	 * not enough ap to perform action } } catch (Exception e) { // do something
	 * with exception } return 0; }
	 */

	public void pullPalaceTile(int level) throws NoPalaceTilesLeft {
		sharedResourcesController.placePalace(level);
	}

	public void returnPalaceTile(int level) {
		sharedResourcesController.returnPalace(level);
	}

	public void undoPalaceTile(int level, int points) {
		sharedResourcesController.returnPalace(level);
		turnController.returnOtherBlock();
		// remove palace tile from board
		boardController.undoTilePlacement();
		turnController.decrementFamePoints(points);
	}

	public void changeTurn() throws BlockNotPlayedException {
		turnController.nextTurn();
		render();
	}

	public void undoChangeTurn() {
		turnController.previousTurn();
	}

	public void endPalaceFestival() {
		// grant points to players as necessary
	}

	public ArrayList<Player> getFestivalVictors() {
		return turnController.getVictors();
	}

	public void drawCard() throws Exception {
		turnController.drawCard(sharedResourcesController.drawCard());
	}

	public void undoDrawCard() {
		sharedResourcesController.returnPalaceCard(turnController.returnCard());
	}

	public void drawFestivalCard() throws Exception {
		turnController.drawFestivalCard(sharedResourcesController.drawCard());
	}

	public void returnFestivalCard() {
		sharedResourcesController.returnCard(turnController.returnFestivalCard());
	}

	public void playCard(String t1, String t2) {
		try {
			turnController.playCard(t1, t2);
			sharedResourcesController.returnPalaceCard(new PalaceCard(t1, t2));
		} catch (Exception e) {
			// state why card could not be played
		}
	}

	public void freezeFestivalPlayer() {
		turnController.freezeFestivalPlayer();
	}

	public Player getCurrentFestivalPlayer() {
		return turnController.getCurrentFestivalPlayer();
	}

	public boolean festivalOver() {
		return turnController.festivalOver();
	}

	public int placeDeveloper() throws Exception {
		String color = turnController.getPlayerColor();
		Color viewColor = turnController.getPlayerViewColor();
		// place a developer at location and get AP spent on action
		Developer d = new Developer(color, viewColor);
		int APUsed = boardController.placeDeveloper(d);
		areaViewportController.setMovementColor(cornflower_blue);
		areaViewportController.setDevColor(cornflower_blue);
		render();
		// then return said AP
		return APUsed;
	}

	public Color getCurrentPlayerColor() {
		return turnController.getPlayerViewColor();
	}

	public void pullDeveloper(int i) throws Exception {
		turnController.placeDeveloper(i);
	}

	public void setDevColor(Color color) {
		areaViewportController.setDevColor(color);
	}

	public int removeDeveloper() throws Exception {
		// remove the developer on the current space of the board
		int APUsed = boardController.removeDeveloper(turnController.getPlayerColor());
		// return the AP spent to remove it
		return APUsed;
	}

	public void undoDeveloperPlacement(int i) throws Exception {
		turnController.undoDeveloperPlacement(i);
		boardController.undoDeveloperPlacement();
		removeDeveloper();
	}

	public void pushDeveloper(int i) throws Exception {
		turnController.removeDeveloper(i);
	}

	public void undoDeveloperRemoval(int i) throws Exception {
		// put developer back on the current space of the board
		String color = turnController.getPlayerColor();
		Color viewColor = turnController.getPlayerViewColor();
		Developer d = new Developer(color, viewColor);
		boardController.placeDeveloper(d);
		turnController.removeDeveloper(i);
	}

	public void replaceDeveloper() throws Exception {
		// put developer on the current space of the board
		String color = turnController.getPlayerColor();
		Color viewColor = turnController.getPlayerViewColor();
		Developer d = new Developer(color, viewColor);
		boardController.placeDeveloper(d);
	}

	public void selectDeveloper() throws Exception {
		boardController.selectDeveloper(turnController.getPlayerColor());
	}

	public void deselectDeveloper() {
		boardController.deselectDeveloper();
	}

	public void createPath() throws Exception {
		renderPath(boardController.shortestPath());
	}

	public int useDevMoveAP() throws Exception {
		turnController.performAction(boardController.shortestPathCost());
		return boardController.shortestPathCost();
	}

	public void unuseDevMoveAP() {
		turnController.undoAction(boardController.shortestPathCost());
	}

	public void moveDeveloper() throws Exception {
		boardController.moveDeveloper();
		// move the developer from its current location to its new location
		// use appropriate amount of AP
	}

	public void unMoveDeveloper() {
		boardController.unMoveDeveloper();
	}

	private void forceDeveloperMove(Location start, Location end) {
		// force any developer on start location to move to end location, if
		// possible
	}

	public void useActionToken() throws Exception {
		turnController.useActionToken();
	}

	public void undoActionToken() {
		turnController.returnActionToken();
	}

	public PalaceFestival getFestival() {
		return turnController.getFestival();
	}

	public void move1() throws LocationOutOfBoundsException {
		if (boardController.getCurrentSpace().getNeighbor(0) != null) {
			HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(0);

			System.out.println("LOC: " + neighbor.getLocation());
			boardController.setCurrentSpace(neighbor);
		} else {
			throw new LocationOutOfBoundsException();
		}
		render();

	}

	public void move2() throws LocationOutOfBoundsException {
		if (boardController.getCurrentSpace().getNeighbor(1) != null) {
			HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(1);

			System.out.println("LOC: " + neighbor.getLocation());
			boardController.setCurrentSpace(neighbor);
			// areaViewportController.scroll(); Test Could possibly do this if
			// there is time
		} else {
			throw new LocationOutOfBoundsException();
		}
		render();

	}

	public void move3() throws LocationOutOfBoundsException {
		if (boardController.getCurrentSpace().getNeighbor(2) != null) {
			HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(2);

			System.out.println("LOC: " + neighbor.getLocation());
			boardController.setCurrentSpace(neighbor);
		} else {
			throw new LocationOutOfBoundsException();
		}
		render();

	}

	public void move7() throws LocationOutOfBoundsException {
		if (boardController.getCurrentSpace().getNeighbor(3) != null) {
			HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(3);

			System.out.println("LOC: " + neighbor.getLocation());
			boardController.setCurrentSpace(neighbor);
		} else {
			throw new LocationOutOfBoundsException();
		}
		render();

	}

	public void move8() throws LocationOutOfBoundsException {
		if (boardController.getCurrentSpace().getNeighbor(4) != null) {
			HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(4);

			System.out.println("LOC: " + neighbor.getLocation());
			boardController.setCurrentSpace(neighbor);
		} else {
			throw new LocationOutOfBoundsException();
		}
		render();

	}

	public void move9() throws LocationOutOfBoundsException {
		if (boardController.getCurrentSpace().getNeighbor(5) != null) {
			HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(5);

			System.out.println("LOC: " + neighbor.getLocation());
			boardController.setCurrentSpace(neighbor);
		} else {
			throw new LocationOutOfBoundsException();
		}
		render();

	}

	public void rotate() {
		boardController.rotate();
		render();
	}

	public void removeErrorMessage() {
		sharedResourcesController.removeErrorMessage();
	}

	public void scoreSurrounding() {
		String[] colors = {};
		// get the colors of the highest positioned developers around a newly
		// placed irrigation tile
		for (String s : colors) {
			turnController.scorePlayer(s, 3);
		}
	}

	public void scorePlayer(String color, int i) {
		turnController.scorePlayer(color, i);
	}
}
