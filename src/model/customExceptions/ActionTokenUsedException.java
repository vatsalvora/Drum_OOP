package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class ActionTokenUsedException extends Exception {

	public ActionTokenUsedException() {

	}

	public ActionTokenUsedException(String message) {
		super(message);
	}

	public String toString() {
		return "Action token has already been used this turn.";
	}
}
