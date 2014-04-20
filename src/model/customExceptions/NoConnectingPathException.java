package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoConnectingPathException extends Exception {

    public NoConnectingPathException(){}

    public String toString()
    {
        return "There is no direct path between these two points.";
    }
}
