package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class BlockNotPlayedException extends Exception {

	public BlockNotPlayedException() {

	}

	public String toString() {
		return "Must play a block this turn before using all AP.";
	}
}
