package model.customExceptions;

public class NoActionTokensException extends Exception {

	public NoActionTokensException() {
	}

	public String toString() {
		return "No action tokens left to play.";
	}
}
