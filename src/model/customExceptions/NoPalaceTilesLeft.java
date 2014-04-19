package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class NoPalaceTilesLeft extends Exception {
    String mess;
    public NoPalaceTilesLeft() {}

    public NoPalaceTilesLeft(String message){
        super(message);
        mess = message;
        }

    public String toString()
    {
        return "No remaining " + mess + " level palaces.";
    }
}
