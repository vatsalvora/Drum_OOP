package model.commands;

import java.util.Stack;
import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.Location;

public class CommandCreator {
	private GameFacade gameFacade;

	private Stack<Command> commands = new Stack<Command>();

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
		Command command = commands.pop();
		command.undo();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Command command : commands) {
			sb.append(command.getClass()).append("\n");
		}
		return sb.toString();
	}
}
