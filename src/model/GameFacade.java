package model;

import controller.AreaViewportController;
import controller.BoardController;
import controller.SharedResourcesController;
import controller.TurnController;
import model.customExceptions.BlockNotPlayedException;
import model.customExceptions.NoIrrigationLeftException;
import model.customExceptions.NoThreeBlockLeftException;
import model.customExceptions.NotEnoughAPException;
import view.keypressed.KeyPressed;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameFacade {
	private BoardController boardController;
	private TurnController turnController;
	private SharedResourcesController sharedResourcesController;
	private AreaViewportController areaViewportController;

	public GameFacade(String[] player) {
		turnController = new TurnController(player);
		boardController = new BoardController();
		sharedResourcesController = new SharedResourcesController();
		areaViewportController = new AreaViewportController(boardController.getBoard());

	}

	public void addKeyListeners(List<KeyPressed> keySet) {
		areaViewportController.addListeners(keySet);
	}

	public void render() {
		areaViewportController.render(boardController.getBoard());
	}

	public void startGame() {
		for (Player p : turnController.getPlayers()) {
			p.addCard(sharedResourcesController.drawCard());
			p.addCard(sharedResourcesController.drawCard());
			p.addCard(sharedResourcesController.drawCard());
		}
	}

    public void setMovementColor(Color color){
        areaViewportController.setMovementColor(color);
    }
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

    public void sendErrorMessage(String s)
    {
        //send the error message to the view
    }

    public void placeOtherBlock() throws NotEnoughAPException
    {
        turnController.placeOtherBlock();
    }

    public void returnOtherBlock()
    {
        turnController.returnOtherBlock();
    }

    public void pullIrrigationTile() throws NoIrrigationLeftException
    {
        sharedResourcesController.placeIrrigationTile();
    }

    public void returnIrrigationTile()
    {
        sharedResourcesController.returnIrrigationTile();
    }

    public int placeIrrigationTile() throws Exception
    {
        //place the irrigation tile on the board
        //give the player the appropriate points (if applicable) and return the points to the command
        return 0;
    }

    public void removeIrrigationTile(int i)
    {
        //take the irrigation tile off of the board
        turnController.decrementFamePoints(i);
    }

	public void undoIrrigationTile(int i) {
		sharedResourcesController.returnIrrigationTile();
		turnController.returnOtherBlock();
		removeIrrigationTile(i);
	}
/*
	public void placeVillageTile() {

        try {
            // place the village at the proper spot
            // give player the proper points (if applicable)
            HexSpace current = boardController.getCurrentSpace();
            Tile t = new VillageTile();
            current.place(t);
            setMovementColor(Color.BLUE);
            render();
        } catch (Exception e) {
            // tell user about error
        }
	}*/

    public int placeVillageTile() throws Exception
    {
        //place the village tile on the board
        //give the player the appropriate points and return them
        return 0;
    }

    public void pullVillageTile() throws Exception
    {
        turnController.placeVillageBlock();
    }

    public void returnVillageTile()
    {
        turnController.returnVillageBlock();
    }

	public void undoVillageTile(int i) {
		turnController.returnVillageBlock();
		// remove the village tile from the location it was placed
		turnController.decrementFamePoints(i);
	}

    public int placeRiceTile() throws Exception
    {
        //place the village tile on the board
        //give the player the appropriate points and return them
        return 0;
    }

    public void pullRiceTile() throws Exception
    {
        turnController.placeRiceBlock();
    }

    public void returnRiceTile()
    {
        turnController.returnRiceBlock();
    }

	public void undoRiceTile(int i) {
		turnController.returnRiceBlock();
		// remove the rice tile from the location it was placed
		turnController.decrementFamePoints(i);
	}
/*
	public void placeDoubleLandTile() {
		try {
			turnController.placeTwoBlock();
			try {
				// place the two block at the proper spot
				// give player the proper points (if applicable)
			} catch (Exception e) {
				turnController.returnTwoBlock();
				// tell user about error
			}
		} catch (Exception e) {
			// do something with exception
		}
	}*/

    public int placeTwoBlock() throws Exception
    {
        //place the village tile on the board
        //give the player the appropriate points and return them
        return 0;
    }

    public void pullTwoBlock() throws Exception
    {
        turnController.placeTwoBlock();
    }

    public void returnTwoBlock()
    {
        turnController.returnTwoBlock();
    }

    public void undoTwoBlock(int i) {
        turnController.returnTwoBlock();
        // remove the two block from the location it was placed
        turnController.decrementFamePoints(i);
    }

	public void undoDoubleLandTile() {
		turnController.returnTwoBlock();
		// remove the two block from the location it was placed
		// remove fame points if applicable
	}
/*
	public void placeTripleLandTile() {
		try {
			sharedResourcesController.placeThreeBlock();
			try {
				turnController.placeOtherBlock();
				try {
					// place the rice at the proper spot
					// give player the proper points (if applicable)
				} catch (Exception e) {
					sharedResourcesController.returnThreeBlock();
					turnController.returnOtherBlock();
					// tell user about error
				}
			} catch (NotEnoughAPException e) {
				// tell user not enough AP remained to play block
				sharedResourcesController.returnThreeBlock();
			}
		} catch (Exception e) {
			// do something with exception
		}
	}*/

    public void pullThreeBlock() throws NoThreeBlockLeftException
    {
        sharedResourcesController.placeThreeBlock();
    }

    public void returnThreeBlock()
    {
        sharedResourcesController.returnThreeBlock();
    }

    public int placeThreeBlock() throws Exception
    {
        //place the three block on the board
        //give the player the appropriate points (if applicable) and return the points to the command
        return 0;
    }

    public void removeThreeBlock(int i)
    {
        //take the three block off of the board
        turnController.decrementFamePoints(i);
    }

    public void undoThreeBlock(int i) {
        sharedResourcesController.returnIrrigationTile();
        turnController.returnOtherBlock();
        removeIrrigationTile(i);
    }

	public void initiatePalaceFestival() {
		String[] colors = {};
		// Get valid colors from the board to turn in to festivals
		turnController.startFestival(colors);
	}

	public void placePalaceTile(HexSpace s, int level) {
		try {
			sharedResourcesController.placePalace(level);
			try {
				turnController.placeOtherBlock();
				try {
					// place the palace at the proper spot
					// give fame points to proper player
					Tile t = new PalaceTile(level);
					s.place(t);
				} catch (Exception e) {
					sharedResourcesController.returnPalace(level);
					// tell user about error
				}
			} catch (NotEnoughAPException e) {
				// tell user not enough ap to perform action
			}
		} catch (Exception e) {
			// do something with exception
		}
	}

	public void undoPalaceTile(Location l, int level) {
		sharedResourcesController.returnPalace(level);
		// remove palace tile from the specified location
		// remove fame points if applicable
	}

	public void changeTurn() throws BlockNotPlayedException {
		turnController.nextTurn();
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

	public void drawCard() {
		try {
			turnController.drawCard(sharedResourcesController.drawCard());
		} catch (Exception e) {
			// tell user why card could not be drawn
		}
	}

	public void undoDrawCard() {
		sharedResourcesController.returnPalaceCard(turnController.returnCard());
	}

	public void drawFestivalCard() {
		try {
			turnController.drawFestivalCard(sharedResourcesController.drawCard());
		} catch (Exception e) {
			// tell user why card could not be drawn
		}
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

	public void placeDeveloper() {
		String color = turnController.getPlayerColor();

		try {
			int APForPlacement = 0;
			// place a developer at location and get AP spent on action
			try {
				turnController.placeDeveloper(APForPlacement);
			} catch (Exception e) {
				// tell user developer cannot be placed due to certain
				// restrictions
				// take the developer off of the location it was placed
			}
		} catch (Exception e) {
			// tell user why developer cannot be placed at that location
		}
	}

	public void undoDeveloperPlacement() {
		int APForPlacement = 0;
		// undo the developer placement at that location and return the AP spent
		// as a result
		turnController.undoDeveloperPlacement(APForPlacement);
	}

	public void removeDeveloper() {
		try {
			// remove a developer of the current player's color from the
			// specified location
			int APForRemoval = 0;
			// return the amount of AP spent removing the developer
			turnController.removeDeveloper(APForRemoval);
		} catch (Exception e) {
			// tell user they do not own a developer at that location
		}
	}

	public void moveDeveloper(Location start, Location end) {
		try {
			// move the developer from start to end
			int APUsed = 0;
			// get the AP used by the move
			try {
				turnController.performAction(APUsed);
			} catch (Exception e) {
				// tell the user why they cannot move the developer
				forceDeveloperMove(end, start); // force the developer to move
												// back
			}
		} catch (Exception e) {
			// tell user why they cannot move developer
		}
	}

	private void forceDeveloperMove(Location start, Location end) {
		// force any developer on start location to move to end location, if
		// possible
	}

	public void useActionToken() {
		try {
			turnController.useActionToken();
		} catch (Exception e) {
			// tell user why action token could not be used
		}
	}

	public void undoActionToken() {
		turnController.returnActionToken();
	}

	public PalaceFestival getFestival() {
		return turnController.getFestival();
	}

	public void move1() {
        if (boardController.getCurrentSpace().getNeighbor(0) != null) {
            HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(0);


            System.out.println("LOC: " + neighbor.getLocation());
            boardController.setCurrentSpace(neighbor);
        }
        render();

	}

	public void move2() {
        if (boardController.getCurrentSpace().getNeighbor(1) != null) {
            HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(1);


            System.out.println("LOC: " + neighbor.getLocation());
            boardController.setCurrentSpace(neighbor);
        }
        render();

	}

	public void move3() {
        if (boardController.getCurrentSpace().getNeighbor(2) != null) {
            HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(2);


            System.out.println("LOC: " + neighbor.getLocation());
            boardController.setCurrentSpace(neighbor);
        }
        render();

	}

	public void move7() {
        if (boardController.getCurrentSpace().getNeighbor(3) != null) {
            HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(3);


            System.out.println("LOC: " + neighbor.getLocation());
            boardController.setCurrentSpace(neighbor);
        }
        render();

	}

	public void move8() {
        if (boardController.getCurrentSpace().getNeighbor(4) != null) {
            HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(4);


            System.out.println("LOC: " + neighbor.getLocation());
            boardController.setCurrentSpace(neighbor);
        }
        render();

	}

	public void move9() {
        if (boardController.getCurrentSpace().getNeighbor(5) != null) {
            HexSpace neighbor = (HexSpace) boardController.getCurrentSpace().getNeighbor(5);


            System.out.println("LOC: " + neighbor.getLocation());
            boardController.setCurrentSpace(neighbor);
        }
        render();

	}


}
