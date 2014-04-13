package model.commands;

import java.util.ArrayList;
import java.util.List;

import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.Location;

public class CommandCreator {
	private GameFacade b;

	private List<Command> commands = new ArrayList<Command>();

	public CommandCreator(GameFacade b) {
		this.b = b;
	}

	public void placeDoubleLandTile(Location l) {
		Command c = new PlaceDoubleLandTile(b, l);
		c.execute();
		commands.add(c);
	}

	public void placeTripleLandTile(Location l) {
		Command c = new PlaceTripleLandTile(b, l);
		c.execute();
		commands.add(c);
	}

	public void placeIrrigationTile(Location l) {
		Command c = new PlaceIrrigationTile(b, l);
		c.execute();
		commands.add(c);
	}

	public void placeRiceTile(Location l) {
		Command c = new PlaceRiceTile(b, l);
		c.execute();
		commands.add(c);
	}

	public void initiatePalaceFestival() {
		Command c = new InitiatePalaceFestival(b);
		c.execute();
		commands.add(c);
	}

	public void endPalaceFestival() {
		Command c = new EndPalaceFestival(b);
		c.execute();
		commands.add(c);
	}

	public void changeTurn() {
		Command c = new ChangeTurn(b);
		c.execute();
		commands.add(c);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Command c : commands) {
			sb.append(c.getClass()).append("\n");
		}
		return sb.toString();
	}
}
