package model;

import java.util.ArrayList;
import java.util.List;

public class CommandCreator {
	private GameFacade b;

	private List<Command> commands = new ArrayList<Command>();

	public CommandCreator(GameFacade b) {
		this.b = b;
	}

	public void PlaceDoubleLandTile(Location l) {
		Command c = new PlaceDoubleLandTile(b, l);
		c.execute();
		commands.add(c);
	}

	public void PlaceTripleLandTile(Location l) {
		Command c = new PlaceTripleLandTile(b, l);
		c.execute();
		commands.add(c);
	}

	public void PlaceIrrigationTile(Location l) {
		Command c = new PlaceIrrigationTile(b, l);
		c.execute();
		commands.add(c);
	}

	public void PlaceRiceTile(Location l) {
		Command c = new PlaceRiceTile(b, l);
		c.execute();
		commands.add(c);
	}

	public void InitiatePalaceFestival() {
		Command c = new InitiatePalaceFestival(b);
		c.execute();
		commands.add(c);
	}

	public void changeTurn() {
		Command c = new ChangeTurn(b);
		c.execute();
		commands.add(c);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (Command c : commands) {
			sb.append(c.getClass() + "\n");
		}
		return sb.toString();
	}
}
