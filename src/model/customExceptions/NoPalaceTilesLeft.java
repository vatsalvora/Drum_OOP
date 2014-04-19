package model.customExceptions;

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
