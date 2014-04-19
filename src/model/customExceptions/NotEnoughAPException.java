package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NotEnoughAPException extends Exception {

	public NotEnoughAPException() {

	}

	public String toString() {
		return "Not enough AP to perform the action.";
	}
}
