package model.customExceptions;

public class NoThreeBlockLeftException extends Exception {
    public NoThreeBlockLeftException()
    {

    }

    public String toString()
    {
        return "No three tile blocks left.";
    }
}
