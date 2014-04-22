package model.customExceptions;

/**
 * Created by Vatsal on 4/22/2014.
 */
public class NoDevsOnBoardException extends Exception {

        public NoDevsOnBoardException() {
        }

        public String toString() {
            return "No developers on Board";
        }

}
