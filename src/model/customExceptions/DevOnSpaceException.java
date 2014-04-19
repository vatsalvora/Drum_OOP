package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class DevOnSpaceException extends Exception {

    public DevOnSpaceException(){}

    public String toString()
    {
        return "There is already a developer on that space.";
    }
}
