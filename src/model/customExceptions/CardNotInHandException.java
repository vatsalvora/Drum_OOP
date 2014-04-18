package model.customExceptions;

/**
 * Created by Thuy on 4/17/2014.
 */
public class CardNotInHandException extends Exception {

    public CardNotInHandException(){}

    public String toString()
    {
        return "You do not own this card.";
    }
}
