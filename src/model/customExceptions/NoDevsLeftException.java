package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoDevsLeftException extends Exception {

	public NoDevsLeftException() {
	}

	public String toString() {
		return "No developers left to play";
	}
}
