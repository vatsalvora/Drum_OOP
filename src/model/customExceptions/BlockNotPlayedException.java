package model.customExceptions;

public class BlockNotPlayedException extends Exception {

    public BlockNotPlayedException()
    {

    }

    public String toString()
    {
        return "Must play a block this turn before using all AP.";
    }
}
