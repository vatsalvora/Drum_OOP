package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class PalacePlayedException extends Exception {

    public PalacePlayedException(){}

    public String toString()
    {
        return "Can only play or upgrade one palace per turn.";
    }
}
