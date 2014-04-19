package model;

import controller.BoardController;
import controller.SharedResourcesController;
import controller.TurnController;
import model.customExceptions.BlockNotPlayedException;
import model.customExceptions.NoIrrigationLeftException;
import model.customExceptions.NotEnoughAPException;

import java.util.ArrayList;

public class GameFacade {
	BoardController boardController;
	TurnController turnController;
	SharedResourcesController sharedResourcesController;

	public GameFacade(String[] player) {
		turnController = new TurnController(player);
		boardController = new BoardController();
		sharedResourcesController = new SharedResourcesController();
	}

    public void startGame()
    {
        for(Player p : turnController.getPlayers())
        {
            p.addCard(sharedResourcesController.drawCard());
            p.addCard(sharedResourcesController.drawCard());
            p.addCard(sharedResourcesController.drawCard());
        }
    }

    public Player[] getPlayers()
    {
        return turnController.getPlayers();
    }

    public Player getCurrentPlayer()
    {
        return turnController.getCurrentPlayer();
    }

    public Board getBoard()
    {
        return boardController.getBoard();
    }

    public HexSpace getCurrentSpace(){return boardController.getCurrentSpace();}
	public void placeIrrigationTile(Location location) {
        try
        {
            sharedResourcesController.placeIrrigationTile();
            try {
                turnController.placeOtherBlock();
                try {
                    //place the irrigation at the proper spot
                    //give player the proper points (if applicable)
                } catch (Exception e) {
                    sharedResourcesController.returnIrrigationTile();
                    turnController.returnOtherBlock();
                    //tell user about error
                }
            }
            catch(NotEnoughAPException e)
            {
                //tell user there was not enough AP to play the irrigation tile
                sharedResourcesController.returnIrrigationTile();
            }
        }
        catch(NoIrrigationLeftException e)
        {
            //print error to user
        }
	}

    public void undoIrrigationTile(Location location)
    {
        sharedResourcesController.returnIrrigationTile();
        turnController.returnOtherBlock();
        //remove the irrigation tile from the location it was placed
        //remove fame points if applicable
    }

	public void placeVillageTile(Location location) {
        try
        {
            turnController.placeVillageBlock();
            try
            {
                //place the village at the proper spot
                //give player the proper points (if applicable)
            }
            catch(Exception e)
            {
                turnController.returnVillageBlock();
                //tell user about error
            }
        }
        catch(Exception e)
        {
            //do something with exception
        }
	}

    public void undoVillageTile(Location location)
    {
        turnController.returnVillageBlock();
        //remove the village tile from the location it was placed
        //remove fame points if applicable
    }

	public void placeRiceTile(Location location) {
        try
        {
            turnController.placeRiceBlock();
            try
            {
                //place the rice at the proper spot
                //give player the proper points (if applicable)
            }
            catch(Exception e)
            {
                turnController.returnRiceBlock();
                //tell user about error
            }
        }
        catch(Exception e)
        {
            //do something with exception
        }
	}

    public void undoRiceTile(Location location)
    {
        turnController.returnRiceBlock();
        //remove the rice tile from the location it was placed
        //remove fame points if applicable
    }

	public void placeDoubleLandTile(Location location) {
        try
        {
            turnController.placeTwoBlock();
            try
            {
                //place the two block at the proper spot
                //give player the proper points (if applicable)
            }
            catch(Exception e)
            {
                turnController.returnTwoBlock();
                //tell user about error
            }
        }
        catch(Exception e)
        {
            //do something with exception
        }
	}

    public void undoDoubleLandTile(Location location)
    {
        turnController.returnTwoBlock();
        //remove the two block from the location it was placed
        //remove fame points if applicable
    }

	public void placeTripleLandTile(Location location) {
        try
        {
            sharedResourcesController.placeThreeBlock();
            try {
                turnController.placeOtherBlock();
                try {
                    //place the rice at the proper spot
                    //give player the proper points (if applicable)
                } catch (Exception e) {
                    sharedResourcesController.returnThreeBlock();
                    turnController.returnOtherBlock();
                    //tell user about error
                }
            }
            catch(NotEnoughAPException e)
            {
                //tell user not enough AP remained to play block
                sharedResourcesController.returnThreeBlock();
            }
        }
        catch(Exception e)
        {
            //do something with exception
        }
	}

    public void undoTripleLandTile(Location location)
    {
        sharedResourcesController.returnThreeBlock();
        turnController.returnOtherBlock();
        //remove three tile block from location it was placed
        //remove fame points if applicable
    }

	public void initiatePalaceFestival() {
        String[] colors = {};
        //Get valid colors from the board to turn in to festivals
        turnController.startFestival(colors);
	}

	public void placePalaceTile(HexSpace s, int level) {
        try
        {
            sharedResourcesController.placePalace(level);
            try {
                turnController.placeOtherBlock();
                try {
                    //place the palace at the proper spot
                    //give fame points to proper player
                    Tile t = new PalaceTile();
                    s.place(t);
                }
                catch (Exception e) {
                    sharedResourcesController.returnPalace(level);
                    //tell user about error
                }
            }
            catch(NotEnoughAPException e)
            {
                //tell user not enough ap to perform action
            }
        }
        catch(Exception e)
        {
            //do something with exception
        }
	}

    public void undoPalaceTile(Location l, int level)
    {
        sharedResourcesController.returnPalace(level);
        //remove palace tile from the specified location
        //remove fame points if applicable
    }

	public void changeTurn() throws BlockNotPlayedException {
        turnController.nextTurn();
	}

    public void undoChangeTurn()
    {
        turnController.previousTurn();
    }

	public void endPalaceFestival() {
        //grant points to players as necessary
	}

    public ArrayList<Player> getFestivalVictors()
    {
        return turnController.getVictors();
    }

    public void drawCard()
    {
        try
        {
            turnController.drawCard(sharedResourcesController.drawCard());
        }
        catch (Exception e)
        {
            //tell user why card could not be drawn
        }
    }

    public void undoDrawCard()
    {
        sharedResourcesController.returnPalaceCard(turnController.returnCard());
    }

    public void drawFestivalCard()
    {
        try{
            turnController.drawFestivalCard(sharedResourcesController.drawCard());
        }
        catch(Exception e)
        {
            //tell user why card could not be drawn
        }
    }

    public void returnFestivalCard()
    {
        sharedResourcesController.returnCard(turnController.returnFestivalCard());
    }

    public void playCard(String t1, String t2)
    {
        try {
            turnController.playCard(t1, t2);
            sharedResourcesController.returnPalaceCard(new PalaceCard(t1, t2));
        }
        catch(Exception e)
        {
            //state why card could not be played
        }
    }

    public void freezeFestivalPlayer()
    {
        turnController.freezeFestivalPlayer();
    }

    public void placeDeveloper(Location location)
    {
        String color = turnController.getPlayerColor();

        try{
            int APForPlacement = 0;
            //place a developer at location and get AP spent on action
            try{
                turnController.placeDeveloper(APForPlacement);
            }
            catch(Exception e)
            {
                //tell user developer cannot be placed due to certain restrictions
                //take the developer off of the location it was placed
            }
        }
        catch(Exception e)
        {
            //tell user why developer cannot be placed at that location
        }
    }

    public void undoDeveloperPlacement(Location location)
    {
        int APForPlacement = 0;
        //undo the developer placement at that location and return the AP spent as a result
        turnController.undoDeveloperPlacement(APForPlacement);
    }

    public void removeDeveloper(Location location)
    {
        try{
            //remove a developer of the current player's color from the specified location
            int APForRemoval = 0;
            //return the amount of AP spent removing the developer
            turnController.removeDeveloper(APForRemoval);
        }
        catch(Exception e)
        {
            //tell user they do not own a developer at that location
        }
    }

    public void moveDeveloper(Location start, Location end)
    {
        try {
            //move the developer from start to end
            int APUsed = 0;
            //get the AP used by the move
            try {
                turnController.performAction(APUsed);
            }
            catch(Exception e)
            {
                //tell the user why they cannot move the developer
                forceDeveloperMove(end, start);         //force the developer to move back
                turnController.undoAction(APUsed);
            }
        }
        catch(Exception e)
        {
            //tell user why they cannot move developer
        }
    }

    public void forceDeveloperMove(Location start, Location end)
    {
        //force any developer on start location to move to end location, if possible
    }

    public void useActionToken()
    {
        try{
            turnController.useActionToken();
        }
        catch(Exception e)
        {
            //tell user why action token could not be used
        }
    }

    public void undoActionToken()
    {
        turnController.returnActionToken();
    }
}
