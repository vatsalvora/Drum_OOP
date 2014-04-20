package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class SpaceIsEmptyException extends Exception{

    public SpaceIsEmptyException(){}

    public String toString()
    {
        return "Cannot place a developer on an empty space.";
    }
}
