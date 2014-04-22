package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
 */

public class OnIrrigationTile extends Exception {

    public OnIrrigationTile(){}

    public String toString()
    {
        return "Cannot place a tile on top of an irrigation tile.";
    }
}
