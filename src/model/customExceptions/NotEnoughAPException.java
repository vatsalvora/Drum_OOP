package model.customExceptions;

/**
 * Created by Thuy on 4/17/2014.
 */
public class NotEnoughAPException extends Exception {

    public NotEnoughAPException()
    {

    }

    public String toString()
    {
        return "Not enough AP to perform the action.";
    }
}
