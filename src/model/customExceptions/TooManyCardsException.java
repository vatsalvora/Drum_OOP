package model.customExceptions;

public class TooManyCardsException extends Exception {

    public TooManyCardsException(){}

    public String toString()
    {
        return "Cannot draw more than two cards in a turn.";
    }
}
