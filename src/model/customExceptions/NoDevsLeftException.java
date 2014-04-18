package model.customExceptions;

public class NoDevsLeftException extends Exception {

    public NoDevsLeftException(){}

    public String toString()
    {
        return "No developers left to play";
    }
}
