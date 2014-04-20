package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class LocationOutOfBoundsException extends Exception {
    public LocationOutOfBoundsException(){}

    public String toString()
    {
        return "Cannot move out of bounds of the board.";
    }
}
