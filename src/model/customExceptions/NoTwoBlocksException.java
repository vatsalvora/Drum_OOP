package model.customExceptions;

/**
 * Created by Thuy on 4/17/2014.
 */
public class NoTwoBlocksException extends Exception {

	public NoTwoBlocksException() {
	}

	public String toString() {
		return "No two blocks left.";
	}
}
