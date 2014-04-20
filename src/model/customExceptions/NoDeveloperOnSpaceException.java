package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoDeveloperOnSpaceException extends Exception {

    public NoDeveloperOnSpaceException(){}

    public String toString()
    {
        return "No developer on selected space.";
    }
}
