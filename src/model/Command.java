package model;

public interface Command {

	void execute();

	void undo();

    boolean save();

	String toString();
}
