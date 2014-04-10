package model;

/**
 * Created by devan on 4/9/14.
 */
public interface State {

    public abstract void changeCurrentState(State state);

    public void changeState(StateType stateType);

    public StateType getCurrentState();

}
