package model;

public interface Command {

	void execute();

	void undo();

    @Override
    String toString();
}
