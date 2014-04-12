package model;

import java.util.ArrayList;
import java.util.List;

/*
 * PalaceFestival holds information for and does calculations
 * of palace festivals.
 */

public class PalaceFestival {
	private PalaceCard festivalCard;
	private ArrayList<Player> players;
	private Player currentPlayer;
	// TODO What is current int? Can we rename this to something more
	// meaningful?
	private int currentInt;
	private int[] playerScores;
	// TODO What is playerFrozen? Can we rename this to something more
	// meaningful?
	private boolean[] playerFrozen;
	private boolean isInProgress;

	public PalaceFestival() {
		festivalCard = null;
		players = new ArrayList<Player>();
		currentPlayer = null;
		currentInt = 0;
		playerScores = new int[4];
		playerFrozen = new boolean[4];
		isInProgress = false;
	}

	public PalaceFestival(PalaceCard c) {
		festivalCard = c;
		players = new ArrayList<Player>();
		currentPlayer = null;
		currentInt = 0;
		playerScores = new int[4];
		playerFrozen = new boolean[4];
		isInProgress = false;
	}

	// Start a new festival by taking in a list of players that can play
	public void startFestival(ArrayList<Player> p) {
		reset();
		players = p;
		currentInt = 0;
		currentPlayer = players.get(currentInt);
		ArrayList<Player> remove = new ArrayList<Player>();
		for (Player player : players) {
			if (!playable(player)) {
				remove.add(player);
			}
		}
		for (Player aRemove : remove) {
			players.remove(aRemove);
		}
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
		currentInt = 0;
		playerScores = new int[4];
		playerFrozen = new boolean[4];
		isInProgress = true;
	}

	// Change festival card
	public PalaceCard changeFestivalCard(PalaceCard palaceCard) {
		PalaceCard old = festivalCard;
		festivalCard = palaceCard;
		return old;
	}

	// Check if a player can still participate (has appropriate card)
	private boolean playable(Player player) {
		return player.hasPlayableCard(festivalCard);
	}

	// Change current player
	public void nextPlayer() {
		if (isInProgress) {
			currentInt++;
			if (currentInt >= players.size()) {
				currentInt = 0;
			}
			currentPlayer = players.get(currentInt);
			if (!playable(currentPlayer)) {
				freeze();
			}
			if (playerFrozen[currentInt]) {
				nextPlayer();
			}
		}
	}

	// Current player playing a card
	public void playCard(PalaceCard playerCard) {
		if (isInProgress) {
			// TODO need to fix compiler errors
			// playerScores[currentInt] += festivalCard.compare(playerCard);
			nextPlayer();
		}
	}

	// Freeze the current player so they cannot perform any more actions
	public void freeze() {
		if (isInProgress) {
			playerFrozen[currentInt] = true;
			boolean dummy = true;
			for (boolean aPlayerFrozen : playerFrozen) {
				if (!aPlayerFrozen) {
					dummy = false;
					break;
				}
			}
			if (dummy) {
				isInProgress = false;
			}
		}
	}

	// Calculate victors
	public List<Player> getVictors() {

		int maxScore = 0;
		List<Player> ret = new ArrayList<Player>();

		for (int playerScore : playerScores) {
			if (playerScore > maxScore) {
				maxScore = playerScore;
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
		return !isInProgress;
	}
}