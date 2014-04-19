package model.customExceptions;

public class NoTwoBlocksException extends Exception {

	public NoTwoBlocksException() {
	}

	public String toString() {
		return "No two blocks left.";
	}
}
