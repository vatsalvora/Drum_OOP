package model;

/**
 * Created by devan on 4/9/14.
 */
public interface State {

	public abstract void changeCurrentState(State state);

	public void changeState(StateType stateType);

	public StateType getCurrentState();

	public void incorrectKeyPressed();

	public void keyPressed1();

	public void keyPressed2();

	public void keyPressed3();

	public void keyPressed7();

	public void keyPressed8();

	public void keyPressed9();

	public void keyPressedTab();

	public void keyPressedR();

	public void keyPressedP();

	public void keyPressedV();

	public void keyPressedI();

	public void keyPressedX();

	public void keyPressedA();

	public void keyPressedESC();

	public void keyPressedF();

	public void keyPressedU();

	public void keyPressedW();

	public void keyPressedE();

	public void keyPressed4();

	public void keyPressed6();

	public void keyPressedEnter();

}
