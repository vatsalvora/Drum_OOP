package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class IncorrectPalaceHeight extends Exception {

	public IncorrectPalaceHeight() {
	}

	public String toString() {
		return "Incorrect Palace Height";
	}
}
