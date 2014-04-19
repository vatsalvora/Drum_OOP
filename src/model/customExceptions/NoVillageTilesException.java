package model.customExceptions;

public class NoVillageTilesException extends Exception {

	public NoVillageTilesException() {
	}

	public String toString() {
		return "No village tiles left.";
	}
}
