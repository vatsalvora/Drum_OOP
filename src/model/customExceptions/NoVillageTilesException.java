package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoVillageTilesException extends Exception {

	public NoVillageTilesException() {
	}

	public String toString() {
		return "No village tiles left.";
	}
}
