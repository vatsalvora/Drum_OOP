package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class SpaceNotOnEdgeException extends Exception {

    public SpaceNotOnEdgeException(){}

    public String toString()
    {
        return "Developer must be placed on the edge of the board.";
    }
}
