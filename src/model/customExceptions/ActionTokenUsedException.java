package model.customExceptions;

public class ActionTokenUsedException extends Exception {

    public ActionTokenUsedException()
    {

    }

    public ActionTokenUsedException(String message)
    {
        super(message);
    }

    public String toString()
    {
        return "Action token has already been used this turn.";
    }
}
