package model;

public interface Command {

	void execute();

	void undo();

	String toString();
}
