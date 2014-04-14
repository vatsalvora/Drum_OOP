package model;

import java.util.*;

/*
 * PalaceFestival holds information for and does calculations
 * of palace festivals.
 */

public class PalaceFestival {
    private PalaceCard festivalCard;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex;
    private int[] playerScores;
    private boolean[] playerFrozen;
    private boolean inProgress;

    public PalaceFestival() {
        festivalCard = null;
        players = new ArrayList<Player>();
        currentPlayer = null;
        currentPlayerIndex = 0;
        playerScores = new int[4];
        playerFrozen = new boolean[4];
        inProgress = false;
    }

    public PalaceFestival(PalaceCard c) {
        festivalCard = c;
        players = new ArrayList<Player>();
        currentPlayer = null;
        currentPlayerIndex = 0;
        playerScores = new int[4];
        playerFrozen = new boolean[4];
        inProgress = false;
    }

    // Get the festival card
    public PalaceCard getFestivalCard() {
        return festivalCard;
    }

    // Get current player
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    // Reset the festival
    private void reset() {
        players = new ArrayList<Player>();
        currentPlayer = null;
        currentPlayerIndex = 0;
        playerScores = new int[4];
        playerFrozen = new boolean[4];
        inProgress = true;
    }

    // Start a new festival by taking in a list of players that can play
    public void startFestival(ArrayList<Player> p) {
        reset();
        players = p;
        currentPlayerIndex = 0;
        currentPlayer = players.get(currentPlayerIndex);
        ArrayList<Player> takeOut = new ArrayList<Player>();
        for (int i = 0; i < players.size(); i++) {
            if (!playable(players.get(i))) {
                takeOut.add(players.get(i));
            }
        }
        for (int i = 0; i < takeOut.size(); i++) {
            players.remove(takeOut.get(i));
        }
    }

    // Change festival card
    public PalaceCard changeFestivalCard(PalaceCard c) {
        PalaceCard old = festivalCard;
        festivalCard = c;
        return old;
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    // Check if a player can still participate (has appropriate card)
    private boolean playable(Player p) {
        return p.hasPlayableCard(festivalCard);
    }

    // Change current player
    public void nextPlayer() {
        if (inProgress) {
            currentPlayerIndex++;
            if (currentPlayerIndex >= players.size()) {
                currentPlayerIndex = 0;
            }
            currentPlayer = players.get(currentPlayerIndex);
            if (!playable(currentPlayer)) {
                freeze();
            }
            if (playerFrozen[currentPlayerIndex]) {
                nextPlayer();
            }
        }
    }

    // Current player playing a card
    public void playCard(PalaceCard c) {
        if (inProgress) {
            playerScores[currentPlayerIndex] += festivalCard.compare(c);
            nextPlayer();
        }
    }

    // Freeze the current player so they cannot perform any more actions
    public void freeze() {
        if (inProgress) {
            playerFrozen[currentPlayerIndex] = true;
            boolean dummy = true;
            for (int i = 0; i < playerFrozen.length; i++) {
                if (!playerFrozen[i]) {
                    dummy = false;
                    break;
                }
            }
            if (dummy) {
                inProgress = false;
            }
        }
    }

    // Calculate victors
    public ArrayList<Player> getVictors() {
        int maxScore = 0;
        ArrayList<Player> ret = new ArrayList<Player>();
        for (int i = 0; i < playerScores.length; i++) {
            if (playerScores[i] > maxScore) {
                maxScore = playerScores[i];
            }
        }
        for (int i = 0; i < playerScores.length; i++) {
            if (playerScores[i] == maxScore) {
                ret.add(players.get(i));
            }
        }
        return ret;
    }

    // Check if the festival is over
    public boolean festivalOver() {
        return !inProgress;
    }
}