package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoRiceBlocksException extends Exception {

	public NoRiceBlocksException() {

	}

	public String toString() {
		return "No rice tiles remaining.";
	}
}
