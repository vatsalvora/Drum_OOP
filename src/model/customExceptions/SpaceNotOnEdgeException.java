package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class SpaceNotOnEdgeException extends Exception {

    String error;

    public SpaceNotOnEdgeException(){
        error = "Developer must be placed on the edge of the board.";
    }

    public SpaceNotOnEdgeException(String error){
        this.error = error;
    }


    public String toString()
    {
        return error;
    }
}
