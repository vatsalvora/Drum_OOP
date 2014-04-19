package model.commands;

import controller.FileController;
import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.Location;

import java.util.Stack;

public class CommandCreator {
	private GameFacade gameFacade;
	private Command current;
	private Stack<Command> commands = new Stack<Command>();
	private Stack<Command> secondCommands = new Stack<Command>();

	public CommandCreator(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	public void placeDoubleLandTile(Location location) {
		current = new PlaceDoubleLandTile(gameFacade, location);
	}

	public void execute() {
		current.execute();
		commands.push(current);

	}

	public void placeTripleLandTile(Location location) {
		current = new PlaceTripleLandTile(gameFacade, location);

	}

	public void placeIrrigationTile(Location location) {
		current = new PlaceIrrigationTile(gameFacade, location);

	}

	public void placeRiceTile(Location location) {
		current = new PlaceRiceTile(gameFacade, location);

	}

	public void placeVillageTile(Location location) {
		current = new PlaceVillageTile(gameFacade, location);

	}

	public void placePalaceTile(Location location, int level) {
		current = new PlacePalaceTile(gameFacade, location, level);

	}

	public void initiatePalaceFestival() {
		current = new InitiatePalaceFestival(gameFacade);

	}

	public void changeTurn() {
		current = new ChangeTurn(gameFacade);

	}

	public void undoLastCommand() {
		if (!commands.empty()) {
			Command command = commands.pop();
			command.undo();
			secondCommands.push(command); // Saves command for re-do in replay
		}
		// TODO: Handle case where stack is empty
	}

	public void redoLastCommand() {
		if (!secondCommands.empty()) {
			Command command = secondCommands.pop();
			command.execute();
			commands.push(command);
		}
		// TODO: Handle case where stack is empty
	}

	public void restart() {
		// For replay mode
		while (!secondCommands.empty())
			redoLastCommand();
		// After this loop, we should be back at the original state before
		// replay
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Command command : commands) {
			sb.append(command.getClass()).append("\n");
		}
		return sb.toString();
	}

	public void save(String fileName) {
        FileController fileController = new FileController();
        fileController.save(fileName, commands);
    }

	public void load(String filename) {
	}
}
