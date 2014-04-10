package model;

/**
 * Created by devan on 4/9/14.
 */
public abstract class State {

    private StateType currentState;

    public abstract void acceptInput(char c);

    private void changeState(StateType stateType){
        this.currentState = stateType;
    }

    public StateType getCurrentState() {
        return currentState;
    }

}
