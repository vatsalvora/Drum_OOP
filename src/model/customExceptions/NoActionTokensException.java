package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoActionTokensException extends Exception {

	public NoActionTokensException() {
	}

	public String toString() {
		return "No action tokens left to play.";
	}
}
