package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoAPLeftException extends Exception {
	public NoAPLeftException() {

	}

	public NoAPLeftException(String message) {
		super(message);
	}

	public String toString() {
		return "No AP left.";
	}
}
