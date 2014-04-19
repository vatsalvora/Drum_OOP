package model.customExceptions;

public class CardNotInHandException extends Exception {

	public CardNotInHandException() {
	}

	public String toString() {
		return "You do not own this card.";
	}
}
