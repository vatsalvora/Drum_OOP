package model.customExceptions;

/*
 * Custom exceptions created to maintain flow, readability, and reduce
 * possible TDA violations
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