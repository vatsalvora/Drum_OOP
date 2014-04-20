package model.customExceptions;

/**
 * Created by Jose on 4/20/2014.
 */
public class SameBlockException extends Exception {

    String error;

    public SameBlockException(String error) {
        this.error = error;
    }

    public String toString() {
        return error;
    }
}