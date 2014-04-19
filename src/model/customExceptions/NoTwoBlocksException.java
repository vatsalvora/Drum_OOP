package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoTwoBlocksException extends Exception {

	public NoTwoBlocksException() {
	}

	public String toString() {
		return "No two blocks left.";
	}
}
