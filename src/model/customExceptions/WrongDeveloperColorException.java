package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class WrongDeveloperColorException extends Exception {

    public WrongDeveloperColorException(){}

    public String toString()
    {
        return "Developer does not belong to the current player.";
    }
}
