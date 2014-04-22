package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class TooManyCardsException extends Exception {

    public TooManyCardsException(){}

    public String toString()
    {
        return "Cannot draw more than two cards in a turn.";
    }
}
