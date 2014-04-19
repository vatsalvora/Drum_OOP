package model.customExceptions;

public class NoRiceBlocksException extends Exception {

	public NoRiceBlocksException() {

	}

	public String toString() {
		return "No rice tiles remaining.";
	}
}
