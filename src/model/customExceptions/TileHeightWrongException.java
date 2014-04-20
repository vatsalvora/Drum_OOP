package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class TileHeightWrongException extends Exception {

    private String message;

    public TileHeightWrongException(String message){
        this.message = message;
    }

    public String toString()
    {
        return message;
    }
}
