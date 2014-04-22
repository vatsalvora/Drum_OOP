package model.commands;

import controller.FileController;
import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.PalaceTile;

import java.awt.*;
import java.io.IOException;
import java.util.Stack;

public class CommandCreator {
	private GameFacade gameFacade;
	private Command current;
	private Stack<Command> commands = new Stack<Command>();
	private Stack<Command> secondCommands = new Stack<Command>();
	private Stack<Command> planningCommands = new Stack<Command>();

	private Color cornflower_blue = new Color(100, 149, 237);
	private boolean planning;

	public CommandCreator(GameFacade gameFacade) {
		this.gameFacade = gameFacade;
		planning = false;
	}

	public void setPlanning(boolean plan) {

        planning = plan;
        if(planning){
            gameFacade.sendErrorMessage("Planning Mode");
            gameFacade.render();
        }
	}

	public void usePlan() {
		for (Command c : planningCommands) {
			commands.push(c);
		}

		StringBuilder sb = new StringBuilder();

		for (Command command : commands) {
            String className = command.getClass().toString();
            String [] name = className.split("\\.");
            sb.append(name[name.length-1]).append("\n");
		}
		gameFacade.sendErrorMessage(sb.toString());
        gameFacade.render();
		System.out.println(sb.toString());
		planningCommands.removeAllElements();
	}

	public void tossPlan() {
		for (Command c : planningCommands) {
			c.undo();
		}
		planningCommands.removeAllElements();
	}

	public void placeDoubleLandTile() {
		Command c = new SetRotation(gameFacade, new int[] { 2 });
		Command m = new ChangeMovementColor(gameFacade, Color.GREEN, Color.GREEN);
		Command p = new ChangeLvlDisplay(gameFacade, 0);
		if (planning) {
			c.execute();
			planningCommands.push(c);

			m.execute();
			planningCommands.push(m);

			p.execute();
			planningCommands.push(p);
		} else {
			c.execute();
			commands.push(c);

			m.execute();
			commands.push(m);

			p.execute();
			commands.push(p);
		}
		current = new PlaceDoubleLandTile(gameFacade);
	}

	public void execute() {
		if (planning) {
			current.execute();
			if (current.save()) {
				planningCommands.push(current);
			}
		} else {
			current.execute();
			if (current.save()) {
				commands.push(current);
			}
		}
		current = null;

		gameFacade.setDevColor(cornflower_blue);
		gameFacade.setMovementColor(cornflower_blue);
		gameFacade.setPalaceLvl(0);
		gameFacade.setRotation(new int[0]);
		gameFacade.render();
	}

	public void move1() {
		Command c = new Move1(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}
		if (current instanceof MoveDeveloper) {
			try {
				gameFacade.createPath();
			} catch (Exception e) {
				// do nothing with exception
			}
		}
		gameFacade.removeErrorMessage();
	}

	public void move2() {
		Command c = new Move2(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}
		if (current instanceof MoveDeveloper) {
			try {
				gameFacade.createPath();
			} catch (Exception e) {
				// do nothing with exception
			}
		}
		gameFacade.removeErrorMessage();
	}

	public void move3() {
		Command c = new Move3(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}
		if (current instanceof MoveDeveloper) {
			try {
				gameFacade.createPath();
			} catch (Exception e) {
				// do nothing with exception
			}
		}
		gameFacade.removeErrorMessage();
	}

	public void move7() {
		Command c = new Move7(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}
		if (current instanceof MoveDeveloper) {
			try {
				gameFacade.createPath();
			} catch (Exception e) {
				// do nothing with exception
			}
		}
		gameFacade.removeErrorMessage();
	}

	public void move8() {
		Command c = new Move8(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}
		if (current instanceof MoveDeveloper) {
			try {
				gameFacade.createPath();
			} catch (Exception e) {
				// do nothing with exception
			}
		}
		gameFacade.removeErrorMessage();
	}

	public void move9() {
		Command c = new Move9(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}
		if (current instanceof MoveDeveloper) {
			try {
				gameFacade.createPath();
			} catch (Exception e) {
				// do nothing with exception
			}
		}
		gameFacade.removeErrorMessage();
	}

	public void placeTripleLandTile() {
		Command c = new SetRotation(gameFacade, new int[] { 2, 3 });
		Command m = new ChangeMovementColor(gameFacade, Color.MAGENTA, Color.MAGENTA);
		Command p = new ChangeLvlDisplay(gameFacade, 0);
		if (planning) {
			c.execute();
			planningCommands.push(c);

			m.execute();
			planningCommands.push(m);

			p.execute();
			planningCommands.push(p);
		} else {
			c.execute();
			commands.push(c);

			m.execute();
			commands.push(m);

			p.execute();
			commands.push(p);
		}

		current = new PlaceTripleLandTile(gameFacade);

	}

	public void placeIrrigationTile() {
		Command r = new SetRotation(gameFacade, new int[0]);
		Command m = new ChangeMovementColor(gameFacade, Color.BLUE, Color.BLUE);
		Command p = new ChangeLvlDisplay(gameFacade, 0);
		if (planning) {
			r.execute();
			planningCommands.push(r);

			m.execute();
			planningCommands.push(m);

			p.execute();
			planningCommands.push(p);
		} else {
			r.execute();
			commands.push(r);

			m.execute();
			commands.push(m);

			p.execute();
			commands.push(p);
		}

		current = new PlaceIrrigationTile(gameFacade);

	}

	public void placeRiceTile() {
		Command r = new SetRotation(gameFacade, new int[0]);
		Command m = new ChangeMovementColor(gameFacade, Color.GREEN, Color.GREEN);
		Command p = new ChangeLvlDisplay(gameFacade, 0);
		if (planning) {
			r.execute();
			planningCommands.push(r);

			m.execute();
			planningCommands.push(m);

			p.execute();
			planningCommands.push(p);
		} else {
			r.execute();
			commands.push(r);

			m.execute();
			commands.push(m);

			p.execute();
			commands.push(p);
		}

		current = new PlaceRiceTile(gameFacade);

	}

	public void placeVillageTile() {
		Command r = new SetRotation(gameFacade, new int[0]);
		Command m = new ChangeMovementColor(gameFacade, Color.RED, Color.RED);
		Command p = new ChangeLvlDisplay(gameFacade, 0);
		if (planning) {
			r.execute();
			planningCommands.push(r);

			m.execute();
			planningCommands.push(m);

			p.execute();
			planningCommands.push(p);
		} else {
			r.execute();
			commands.push(r);

			m.execute();
			commands.push(m);

			p.execute();
			commands.push(p);
		}

		current = new PlaceVillageTile(gameFacade);

	}

	public void placePalaceTile() {
		Command r = new SetRotation(gameFacade, new int[0]);
		Command m = new ChangeMovementColor(gameFacade, Color.YELLOW, Color.YELLOW);
		int lvl = gameFacade.getPalaceLvl();
		if (lvl <= 8)
			lvl += 2;

		Command p = new ChangeLvlDisplay(gameFacade, lvl);

		if (planning) {
			r.execute();
			planningCommands.push(r);

			m.execute();
			planningCommands.push(m);

			p.execute();
			planningCommands.push(p);
		} else {
			r.execute();
			commands.push(r);

			m.execute();
			commands.push(m);

			p.execute();
			commands.push(p);
		}

		current = new PlacePalaceTile(gameFacade, lvl);

	}

	public void upgradePalaceTile() {
		Command r = new SetRotation(gameFacade, new int[0]);
		Command m = new ChangeMovementColor(gameFacade, Color.YELLOW, Color.YELLOW);
		PalaceTile pt = (PalaceTile) gameFacade.getCurrentSpace().getTopTile();
		if (pt != null) {
			int lvl = gameFacade.getPalaceLvl();
			if (pt.getLvl() > lvl)
				lvl = pt.getLvl();
			if (lvl <= 8)
				lvl += 2;
			Command p = new ChangeLvlDisplay(gameFacade, lvl);
			if (planning) {
				r.execute();
				planningCommands.push(r);

				m.execute();
				planningCommands.push(m);

				p.execute();
				planningCommands.push(p);
			} else {
				r.execute();
				commands.push(r);

				m.execute();
				commands.push(m);

				p.execute();
				commands.push(p);
			}
			current = new PlacePalaceTile(gameFacade, lvl);

		}

	}

	public void initiatePalaceFestival() {
		// current = new InitiatePalaceFestival(gameFacade);
		if (!planning) {
			Command c = new InitiatePalaceFestival(gameFacade);
			c.execute();
		}
	}

	public void changeTurn() {
		Command c = new ChangeTurn(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}

	}

	public void placeDeveloper() {
		Command m = new ChangeMovementColor(gameFacade, gameFacade.getCurrentPlayerColor(),
				cornflower_blue);
		Command r = new SetRotation(gameFacade, new int[0]);
		Command p = new ChangeLvlDisplay(gameFacade, 0);
		if (planning) {
			m.execute();
			planningCommands.push(m);

			r.execute();
			planningCommands.push(r);

			p.execute();
			planningCommands.push(p);
		} else {
			m.execute();
			commands.push(m);

			r.execute();
			commands.push(r);

			p.execute();
			commands.push(p);
		}
		current = new PlaceDeveloper(gameFacade);
	}

	public void removeDeveloper() {
		current = new RemoveDeveloper(gameFacade);
	}

	public void selectDeveloper() {
		Command m = new ChangeMovementColor(gameFacade, gameFacade.getCurrentPlayerColor(),
				cornflower_blue);
		Command r = new SetRotation(gameFacade, new int[0]);
		Command p = new ChangeLvlDisplay(gameFacade, 0);
		Command c = new SelectDeveloper(gameFacade);
		if (planning) {
			m.execute();
			planningCommands.push(m);

			r.execute();
			planningCommands.push(r);

			p.execute();

			c.execute();
			if (c.save()) {
				planningCommands.push(c);
				current = new MoveDeveloper(gameFacade);
			} else {
				current = null;
			}
		} else {
			m.execute();
			commands.push(m);

			r.execute();
			commands.push(r);

			p.execute();

			c.execute();
			if (c.save()) {
				commands.push(c);
				current = new MoveDeveloper(gameFacade);
			} else {
				current = null;
			}
		}

	}

	public void undoAll() {
		while (!commands.empty()) {
			undoLastCommand();
		}
	}

	public void undoLastCommand() {
		if (!commands.empty()) {
			Command command = commands.pop();
			command.undo();
			secondCommands.push(command); // Saves command for re-do in replay
		}
	}

	public void tabDeveloper() {
		Command command = new TabDeveloper(gameFacade);
		command.execute();
	}

	public void redoLastCommand() {
		if (!secondCommands.empty()) {
			Command command = secondCommands.pop();
			command.execute();
			commands.push(command);
		}
	}

	public void restart() {
		// For replay mode
		while (!secondCommands.empty())
			redoLastCommand();
		// After this loop, we should be back at the original state before
		// replay
	}

	public void useActionToken() {
		Command c = new UseActionToken(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}

	}

	public void drawCard() {
		Command c = new DrawCard(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}

	}

	public void drawFestivalCard() {
		Command c = new DrawPalaceCard(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}

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
		fileController.save(fileName, commands, gameFacade);
	}

	public void load(String filename) throws IOException {
		FileController fileController = new FileController();
		fileController.load(filename);
	}

	public void rotate() {
		Command c = new Rotate(gameFacade);
		if (planning) {
			c.execute();
			if (c.save()) {
				planningCommands.push(c);
			}
		} else {
			c.execute();
			if (c.save()) {
				commands.push(c);
			}
		}

	}

}
