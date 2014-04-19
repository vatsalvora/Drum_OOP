package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class CardNotPlayableException extends Exception {

	public CardNotPlayableException() {
	}

	public String toString() {
		return "Card cannot be played because it does not match the festival card.";
	}
}
