package model.customExceptions;

public class NoAPLeftException extends Exception {
	public NoAPLeftException() {

	}

	public NoAPLeftException(String message) {
		super(message);
	}

	public String toString() {
		return "No AP left.";
	}
}
