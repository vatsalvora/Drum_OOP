package model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final static Logger LOGGER = Logger.getLogger(TurnController.class.getName());


    public TurnController(String[] name) {
        String[] color = {"red", "blue", "green", "yellow"};
        numPlayers = name.length;

        //TODO throw exception if greater that 4
        if (numPlayers > 4) {
            LOGGER.log(Level.WARNING, "Incorrect number of players. Setting numPlayers to 4.");
            numPlayers = 4;
        }

        players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(name[i], color[i]);
        }

        actionTokenUsed = false;
        blockPlayed = 0;
        festival = new PalaceFestival();
        currentPlayerIndex = 0;
        currentPlayer = players[currentPlayerIndex];
        actionPoints = 6;
    }

    // Turn control methods
    public void nextTurn() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= numPlayers) {
            currentPlayerIndex = 0;
        }
        currentPlayer = players[currentPlayerIndex];
        actionTokenUsed = false;
        blockPlayed = 0;
        actionPoints = 6;
    }

    public void previousTurn() {
        currentPlayerIndex--;
        if (currentPlayerIndex < 0) {
            currentPlayerIndex = numPlayers - 1;
        }
        currentPlayer = players[currentPlayerIndex];
    }

    // Altering current player methods
    public void incrementFamePoints(int i) {
        currentPlayer.incrementFamePoints(i);
    }

    public void decrementFamePoints(int i) throws Exception {
        currentPlayer.decrementFamePoints(i);
    }

    public void placeDeveloper() {
        currentPlayer.placeDeveloper();
    }

    public void removeDeveloper() {
        currentPlayer.removeDeveloper();
    }

    public void useActionToken() {
        if (actionTokenUsed) {
            // put-in: action token already used error
        } else {
            currentPlayer.useActionToken();
            actionTokenUsed = true;
            actionPoints--;
        }
    }

    public void returnActionToken() {
        currentPlayer.returnActionToken();
        actionTokenUsed = false;
        actionPoints++;
    }

    public void placeRiceBlock() {
        if (actionPoints > 0) {
            currentPlayer.placeRiceBlock();
//            actionPoints--;
//            blockPlayed++;
            decrementActionPointsAndIncrementBlockPlayed();
        } else {
            // put-in: no AP left error
        }
    }

    public void returnRiceBlock() {
        currentPlayer.returnRiceBlock();
//        actionPoints++;
//        blockPlayed--;
        incrementActionPointsAndDecrementBlockPlayed();
    }

    public void placeVillageBlock() {
        if (actionPoints > 0) {
            currentPlayer.placeVillageBlock();
//            actionPoints--;
//            blockPlayed++;
            decrementActionPointsAndIncrementBlockPlayed();
        } else {
            // put-in: no AP left error
        }
    }

    public void returnVillageBlock() {
        currentPlayer.returnVillageBlock();
//        actionPoints++;
//        blockPlayed--;
        incrementActionPointsAndDecrementBlockPlayed();
    }

    public void placeTwoBlock() {
        if (actionPoints > 0) {
            currentPlayer.placeTwoBlock();
//            actionPoints--;
//            blockPlayed++;
            decrementActionPointsAndIncrementBlockPlayed();
        } else {
            // put-in: no AP left error
        }
    }

    public void returnTwoBlock() {
        currentPlayer.returnTwoBlock();
//        actionPoints++;
//        blockPlayed--;
        incrementActionPointsAndDecrementBlockPlayed();
    }

    public void addCard(PalaceCard c) {
        if (c != null) {
            currentPlayer.addCard(c);
        }
    }

    public void drawCard(PalaceCard c) {
        if (actionPoints > 0) {
            if (actionPoints == 1 && blockPlayed == 0) {
                // put-in: using all AP and block not placed error
            } else {
                actionPoints--;
                currentPlayer.addCard(c);
            }
        } else {
            // put-in: not enough AP error
        }
    }

    public void drawFestivalCard(PalaceCard c) {
        if (c != null) {
            if (actionPoints > 0) {
                if (actionPoints == 1 && blockPlayed == 0) {
                    // put-in: using all AP and block not placed error
                } else {
                    actionPoints--;
                    currentPlayer.addCard(festival.changeFestivalCard(c));
                }
            } else {
                // put-in: not enough AP error
            }
        }
    }

    // Actions that do not require the current player.
    public void placeOtherBlock() {
        if (actionPoints > 0) {
//            actionPoints--;
//            blockPlayed++;
            decrementActionPointsAndIncrementBlockPlayed();
        } else {
            // put-in: not enough AP error
        }
    }

    public void returnOtherBlock() {
//        actionPoints++;
//        blockPlayed--;
        incrementActionPointsAndDecrementBlockPlayed();
    }

    public void performAction(int i) {
        if (actionPoints == 0) {
            // put-in: no AP error
        } else if (actionPoints < i) {
            // put-in: not enough AP error
        } else if (actionPoints == i) {
            if (blockPlayed > 0) {
                actionPoints -= i;
            } else {
                // put-in: using all AP but block has not been placed error
            }
        } else {
            actionPoints -= i;
        }
    }

    public void undoAction(int i) throws Exception {
        if(i + actionPoints >= 7){
            throw new Exception("Cannot undo action. Action points already over 7.");
        }
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

    public void changeFestivalPlayer() {
        festival.nextPlayer();
    }

    public void playCard(String t1, String t2) {
        PalaceCard play = new PalaceCard(t1, t2);
        if (currentPlayer.hasPlayableCard(play) && play.compare(festival.getFestivalCard()) > 0) {
            festival.playCard(play);
            currentPlayer.removeCard(play);
        } else {
            // put-in: card cannot be played since it doesn't match festival
            // card in any way
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
//        boolean ret = false;
//        if (blockPlayed > 0) {
//            ret = true;
//        }
//        return ret;
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

    public List<PalaceCard> getCurrentCards() {
        return currentPlayer.getCards();
    }

    private void decrementActionPointsAndIncrementBlockPlayed() {
        actionPoints--;
        blockPlayed++;
    }

    private void incrementActionPointsAndDecrementBlockPlayed() {
        actionPoints++;
        blockPlayed--;
    }
}