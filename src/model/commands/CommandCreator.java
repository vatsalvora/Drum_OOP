package model.commands;

import controller.FileController;
import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.HexSpace;

import java.util.Stack;

public class CommandCreator {
	private GameFacade gameFacade;
	private Command current;
	private Stack<Command> commands = new Stack<Command>();
	private Stack<Command> secondCommands = new Stack<Command>();

	public CommandCreator(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
	}

	public void placeDoubleLandTile() {
		current = new PlaceDoubleLandTile(gameFacade);
	}

	public void execute() {
		current.execute();
		commands.push(current);
	}

	public void placeTripleLandTile() {
		current = new PlaceTripleLandTile(gameFacade);

	}

	public void move1() {
		current = new Move1(gameFacade);

	}

	public void move2() {
		current = new Move2(gameFacade);

	}

	public void move3() {
		current = new Move3(gameFacade);

	}

	public void move7() {
		current = new Move7(gameFacade);

	}

	public void move8() {
		current = new Move8(gameFacade);

	}

	public void move9(HexSpace hex) {
		current = new Move9(gameFacade);

	}

	public void placeIrrigationTile() {
		current = new PlaceIrrigationTile(gameFacade);

	}

	public void placeRiceTile() {
		current = new PlaceRiceTile(gameFacade);

	}

	public void placeVillageTile() {
		current = new PlaceVillageTile(gameFacade);

	}

	public void placePalaceTile(int level) {
		current = new PlacePalaceTile(gameFacade, level);

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
