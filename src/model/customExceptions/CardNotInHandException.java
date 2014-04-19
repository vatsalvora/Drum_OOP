package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class CardNotInHandException extends Exception {

	public CardNotInHandException() {
	}

	public String toString() {
		return "You do not own this card.";
	}
}
