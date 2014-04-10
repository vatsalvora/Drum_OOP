package model;

/**
 * Created by devan on 4/9/14.
 */
public class Replay extends State {

    @Override
    public void acceptInput(char c) {
        switch(c){
            case 'R':
                //restart
                break;
            case '4':
                //go back
                break;
            case '6':
                //go forward
                break;
        }
    }
}
