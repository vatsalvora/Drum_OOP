package model.commands;

import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.Location;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Stack;

public class CommandCreator {
	private GameFacade gameFacade;

	private Stack<Command> commands = new Stack<Command>();
	private Stack<Command> secondCommands = new Stack<Command>();

	public CommandCreator(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	public void placeDoubleLandTile(Location location) {
		Command command = new PlaceDoubleLandTile(gameFacade, location);
		command.execute();
		commands.push(command);
	}

	public void placeTripleLandTile(Location location) {
		Command command = new PlaceTripleLandTile(gameFacade, location);
		command.execute();
		commands.push(command);
	}

	public void placeIrrigationTile(Location location) {
		Command command = new PlaceIrrigationTile(gameFacade, location);
		command.execute();
		commands.push(command);
	}

	public void placeRiceTile(Location location) {
		Command command = new PlaceRiceTile(gameFacade, location);
		command.execute();
		commands.push(command);
	}

	public void placeVillageTile(Location location) {
		Command command = new PlaceVillageTile(gameFacade, location);
		command.execute();
		commands.push(command);
	}

	public void placePalaceTile(Location location) {
		System.out.println("Placing palace at" + location);
		Command command = new PlacePalaceTile(gameFacade, location);
		command.execute();
		commands.push(command);
	}

	public void initiatePalaceFestival() {
		Command command = new InitiatePalaceFestival(gameFacade);
		command.execute();
		commands.push(command);
	}

	public void changeTurn() {
		Command command = new ChangeTurn(gameFacade);
		command.execute();
		commands.push(command);
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
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName);
			for (Command comm : commands) {
				writer.println(comm);
			}
			writer.close();
			System.out.println("File saved");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void load(String filename) {
	}
}
