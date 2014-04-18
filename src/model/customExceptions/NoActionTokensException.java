package model.customExceptions;

/**
 * Created by Thuy on 4/17/2014.
 */
public class NoActionTokensException extends Exception {

    public NoActionTokensException(){}

    public String toString()
    {
        return "No action tokens left to play.";
    }
}
