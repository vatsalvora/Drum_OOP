package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoIrrigationLeftException extends Exception{

    public NoIrrigationLeftException(){}

    public String toString()
    {
        return "No irrigation tiles left to play.";
    }
}
