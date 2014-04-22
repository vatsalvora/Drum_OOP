package controller;

import model.PalaceCard;
import model.PalaceFestival;
import model.Player;
import model.customExceptions.*;

import java.awt.*;
import java.util.ArrayList;

/*
 * TurnController manages anything a player can do with their 
 * inventory during a turn, including inventory checking, 
 * palace festivals, and inventory management.
 */

public class TurnController {
    private Player[] players;
    private Player currentPlayer;
    private int currentPlayerIndex;
    private int numPlayers;
    private int actionPoints;
    private boolean actionTokenUsed;
    private int blockPlayed;
    private PalaceFestival festival;
    private int cardsDrawn;


    public TurnController(String[] name) {
        String[] color = {"red", "blue", "green", "yellow"};
        Color[] viewColor = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        numPlayers = name.length;

        if (numPlayers > 4) {
            numPlayers = 4;
        }

        players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(name[i], color[i],viewColor[i]);
        }

        actionTokenUsed = false;
        blockPlayed = 0;
        festival = new PalaceFestival();
        currentPlayerIndex = 0;
        currentPlayer = players[currentPlayerIndex];
        actionPoints = 6;
        cardsDrawn = 0;
    }

    // Turn control methods
    public void nextTurn() throws BlockNotPlayedException {
        if(blockPlayed > 0) {
            currentPlayerIndex++;
            if (currentPlayerIndex >= numPlayers) {
                currentPlayerIndex = 0;
            }
            currentPlayer = players[currentPlayerIndex];
            System.out.println(currentPlayer.getName());
            actionTokenUsed = false;
            blockPlayed = 0;
            actionPoints = 6;
            cardsDrawn = 0;
        }
        else
        {
            throw new BlockNotPlayedException();
        }
    }

    public void previousTurn() {
        currentPlayerIndex--;
        if (currentPlayerIndex < 0) {
            currentPlayerIndex = numPlayers - 1;
        }
        currentPlayer = players[currentPlayerIndex];
        System.out.println(currentPlayer.getName());
        blockPlayed = 6;
        actionPoints = 0;
        cardsDrawn = 2;
    }

    public Color getPlayerViewColor(){return currentPlayer.getViewColor();}
    // Altering current player methods
    public void incrementFamePoints(int i) {
        currentPlayer.incrementFamePoints(i);
    }

    public void decrementFamePoints(int i){
        currentPlayer.decrementFamePoints(i);
    }

    public void placeDeveloper(int i) throws BlockNotPlayedException, NotEnoughAPException, NoDevsLeftException {

        currentPlayer.placeDeveloper();
        if(actionPoints > i)
        {
            actionPoints -= i;
        }
        else if (actionPoints == i)
        {
            if(blockPlayed > 0)
            {
                actionPoints -= i;
            }
            else
            {
                currentPlayer.removeDeveloper();
                throw new BlockNotPlayedException();
            }
        }
        else
        {
            currentPlayer.removeDeveloper();
            throw new NotEnoughAPException();
        }
    }

    public void undoDeveloperPlacement(int i)
    {
        currentPlayer.removeDeveloper();
        actionPoints += i;
    }

    public void removeDeveloper(int i) throws Exception {
        if (actionPoints > i){
            actionPoints -= i;
            currentPlayer.removeDeveloper();
        }
        else if(actionPoints == i)
        {
            if(playedBlock())
            {
                actionPoints -= i;
                currentPlayer.removeDeveloper();
            }
            else
                throw new BlockNotPlayedException();
        }
        else
        {
            throw new NoAPLeftException();
        }
    }

    public void useActionToken() throws ActionTokenUsedException, NoActionTokensException{
        if (actionTokenUsed) {
            throw new ActionTokenUsedException();
        } else {
            currentPlayer.useActionToken();
            actionTokenUsed = true;
            actionPoints++;
        }
    }

    public void returnActionToken() {
        currentPlayer.returnActionToken();
        actionTokenUsed = false;
        actionPoints--;
    }

    public void placeRiceBlock() throws NoAPLeftException, NoRiceBlocksException {
        if (actionPoints > 0) {
            currentPlayer.placeRiceBlock();
            actionPoints--;
            blockPlayed++;
        } else {
            throw new NoAPLeftException();
        }
    }

    public void returnRiceBlock() {
        currentPlayer.returnRiceBlock();
        actionPoints++;
        blockPlayed--;
    }

    public void placeVillageBlock() throws NoAPLeftException, NoVillageTilesException {
        if (actionPoints > 0) {
            currentPlayer.placeVillageBlock();
            actionPoints--;
            blockPlayed++;
        } else {
            throw new NoAPLeftException();
        }
    }

    public void returnVillageBlock() {
        System.out.println(currentPlayer);
        System.out.println(blockPlayed);
        currentPlayer.returnVillageBlock();
        actionPoints++;
        blockPlayed--;
    }

    public void placeTwoBlock() throws NoAPLeftException, NoTwoBlocksException {
        if (actionPoints > 0) {
            currentPlayer.placeTwoBlock();
            actionPoints--;
            blockPlayed++;
        } else {
            throw new NoAPLeftException();
        }
    }

    public void returnTwoBlock() {
        currentPlayer.returnTwoBlock();
        actionPoints++;
        blockPlayed--;
    }

    public void addCard(PalaceCard c) {
        if (c != null) {
            currentPlayer.addCard(c);
        }
    }

    public void drawCard(PalaceCard c) throws NoAPLeftException, BlockNotPlayedException, TooManyCardsException {
        if (actionPoints > 0) {
            if (actionPoints == 1 && blockPlayed == 0) {
                throw new BlockNotPlayedException();
            } else {
                if(cardsDrawn < 2) {
                    actionPoints--;
                    currentPlayer.addCard(c);
                    cardsDrawn++;
                }
                else
                {
                    throw new TooManyCardsException();
                }
            }
        } else {
            throw new NoAPLeftException();
        }
    }

    public PalaceCard returnCard()
    {
        cardsDrawn--;
        return currentPlayer.returnCard();
    }

    public void drawFestivalCard(PalaceCard c) throws BlockNotPlayedException, NotEnoughAPException, TooManyCardsException {
        if (c != null) {
            if (actionPoints > 0) {
                if (actionPoints == 1 && blockPlayed == 0) {
                    throw new BlockNotPlayedException();
                } else {
                    if(cardsDrawn < 2) {
                        cardsDrawn++;
                        actionPoints--;
                        currentPlayer.addCard(festival.changeFestivalCard(c));
                    }
                    else
                    {
                        throw new TooManyCardsException();
                    }
                }
            } else {
                throw new NotEnoughAPException();
            }
        }
    }

    public PalaceCard returnFestivalCard()
    {
        cardsDrawn--;
        return festival.changeFestivalCard(currentPlayer.returnCard());
    }

    // Actions that do not require the current player's inventory.
    public void placeOtherBlock() throws NotEnoughAPException {
        if (actionPoints > 0) {
            actionPoints--;
            blockPlayed++;
        } else {
            throw new NotEnoughAPException();
        }
    }

    public void returnOtherBlock() {
        System.out.println("Increasing action points.");
        actionPoints++;
        blockPlayed--;
    }

    public void performAction(int i) throws NoAPLeftException, BlockNotPlayedException, NotEnoughAPException {
        if (actionPoints == 0) {
            throw new NoAPLeftException();
        } else if (actionPoints < i) {
            throw new NotEnoughAPException();
        } else if (actionPoints == i) {
            if (blockPlayed > 0) {
                actionPoints -= i;
            } else {
                throw new BlockNotPlayedException();
            }
        } else {
            actionPoints -= i;
        }
    }

    public void undoAction(int i) {
        actionPoints += i;
    }

    // Festival accessor methods
    public PalaceFestival getFestival() {
        return festival;
    }

    public void startFestival(String[] colors) {
        ArrayList<Player> inFestival = new ArrayList<Player>();
        for (String color : colors) {
            for (int j = 0; j < numPlayers; j++) {
                if (color.equals(players[j].getColor())) {
                    inFestival.add(players[j]);
                }
            }
        }
        festival.startFestival(inFestival);
    }

    public void playCard(String t1, String t2) throws CardNotPlayableException, CardNotInHandException {
        PalaceCard play = new PalaceCard(t1, t2);
        Player festivalPlayer = festival.getCurrentPlayer();
        if (festivalPlayer.hasCard(play) && play.compare(festival.getFestivalCard()) > 0) {
            festival.playCard(play);
            festivalPlayer.removeCard(play);
        } else {
            throw new CardNotPlayableException();
        }
    }

    public void freezeFestivalPlayer() {
        festival.freeze();
    }

    public ArrayList<Player> getVictors() {
        return festival.getVictors();
    }

    public Player getCurrentFestivalPlayer() {
        return festival.getCurrentPlayer();
    }

    public ArrayList<Player> getFestivalPlayers() {
        return festival.getPlayers();
    }

    public PalaceCard getFestivalCard() {
        return festival.getFestivalCard();
    }

    public boolean festivalOver() {
        return festival.festivalOver();
    }

    // General getters
    public int APLeft() {
        return actionPoints;
    }

    public boolean playedBlock() {
        return (blockPlayed > 0);
    }

    public boolean tokenUsed() {
        return actionTokenUsed;
    }

    // Player accessor methods
    public Player[] getPlayers() {
        return players;
    }

    // Current player accessor methods
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getPlayerName() {
        return currentPlayer.getName();
    }

    public String getPlayerColor() {
        return currentPlayer.getColor();
    }
    
    public int getNumPlayers()
    {
    	return numPlayers;
    }
    
    public int getCurrentPlayerIndex()
    {
    	return currentPlayerIndex;
    }
    
    public String getPlayerInfo(int playerNumber)
    {
    	if(playerNumber <= numPlayers)
    		return players[playerNumber-1].toString();
    	else
    		return "";
    }

    public String getPlayerCardInfo()
    {
    	return players[currentPlayerIndex].palaceCardsToString();
    }
    public ArrayList<PalaceCard> getCurrentCards() {
        return currentPlayer.getCards();
    }
    
    public String getCurrentFestivalCard()
    {
    	return (festival.getFestivalCard().toString());
    }

    public void putFestivalCard(PalaceCard c)
    {
        festival.changeFestivalCard(c);
    }
    
  

    public void endFestival()
    {
        festival.endFestival();
    }

    public void scorePlayer(String s, int i) {
        for(Player p : players)
        {
            if(p.getColor().compareTo(s) == 0)
            {
                p.incrementFamePoints(i);
                break;
            }
        }
    }
}