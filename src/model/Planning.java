package model;

/**
 * Created by devan on 4/9/14.
 */
public class Planning extends State {

    @Override
    public void acceptInput(char c) {
        switch (c) {
            case '1': //Move selected item SW
                break;
            case '2': //Move selected item S
                break;
            case '3': //Move SE
                break;
            case '7': //Move NE
                break;
            case '8': //Move N
                break;
            case '9': //Move NW
                break;
            case '\t': //Tab through Developer
                break;
            case 'R': //Select Rice Tile
                break;
            case 'P': //Place new Palace
                break;
            case 'X': //END TURN
                break;
            case '\r': //execute
                break;
        }
    }
}
