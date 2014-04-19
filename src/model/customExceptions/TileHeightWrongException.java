package model.customExceptions;

public class TileHeightWrongException extends Exception {

    public TileHeightWrongException(){}

    public String toString()
    {
        return "Tile heights are inconsistent in the area the block is being placed.";
    }
}
