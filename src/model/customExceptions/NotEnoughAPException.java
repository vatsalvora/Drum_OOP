package model.customExceptions;

public class NotEnoughAPException extends Exception {

	public NotEnoughAPException() {

	}

	public String toString() {
		return "Not enough AP to perform the action.";
	}
}
