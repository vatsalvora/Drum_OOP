package model.customExceptions;

public class NoIrrigationLeftException extends Exception{

    public NoIrrigationLeftException(){}

    public String toString()
    {
        return "No irrigation tiles left to play.";
    }
}
