package model.commands;

import java.util.Stack;
import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.Location;

public class CommandCreator {
	private GameFacade b;

	private Stack<Command> commands = new Stack<Command>();

	public CommandCreator(GameFacade b) {
		this.b = b;
	}

	public void placeDoubleLandTile(Location l) {
		Command c = new PlaceDoubleLandTile(b, l);
		c.execute();
		commands.push(c);
	}

	public void placeTripleLandTile(Location l) {
		Command c = new PlaceTripleLandTile(b, l);
		c.execute();
		commands.push(c);
	}

	public void placeIrrigationTile(Location l) {
		Command c = new PlaceIrrigationTile(b, l);
		c.execute();
		commands.push(c);
	}

	public void placeRiceTile(Location l) {
		Command c = new PlaceRiceTile(b, l);
		c.execute();
		commands.push(c);
	}

	public void initiatePalaceFestival() {
		Command c = new InitiatePalaceFestival(b);
		c.execute();
		commands.push(c);
	}

	public void endPalaceFestival() {
		Command c = new EndPalaceFestival(b);
		c.execute();
		commands.push(c);
	}

	public void changeTurn() {
		Command c = new ChangeTurn(b);
		c.execute();
		commands.push(c);
	}

	public void undoLastCommand() {
		Command c = commands.pop();
		c.undo();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Command c : commands) {
			sb.append(c.getClass()).append("\n");
		}
		return sb.toString();
	}
}
