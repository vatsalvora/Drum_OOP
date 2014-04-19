package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoThreeBlockLeftException extends Exception {
    public NoThreeBlockLeftException()
    {

    }

    public String toString()
    {
        return "No three tile blocks left.";
    }
}
