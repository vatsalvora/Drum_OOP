package model.commands;

import controller.FileController;
import model.ChangeTurn;
import model.Command;
import model.GameFacade;

import java.io.IOException;
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
        if (current.save()) {
            commands.push(current);
        }
    }

    public void move1() {
        Command c = new Move1(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void move2() {
        Command c = new Move2(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void move3() {
        Command c = new Move3(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void move7() {
        Command c = new Move7(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void move8() {
        Command c = new Move8(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void move9() {
        Command c = new Move9(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void placeTripleLandTile() {
        current = new PlaceTripleLandTile(gameFacade);

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
        //current = new InitiatePalaceFestival(gameFacade);
        Command c = new InitiatePalaceFestival(gameFacade);
        c.execute();
    }

    public void changeTurn() {
        Command c = new ChangeTurn(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void placeDeveloper()
    {
        current = new PlaceDeveloper(gameFacade);
    }

    public void removeDeveloper()
    {
        current = new RemoveDeveloper(gameFacade);
    }

    public void undoLastCommand() {
        if (!commands.empty()) {
            Command command = commands.pop();
            command.undo();
            secondCommands.push(command); // Saves command for re-do in replay
        }
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
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void drawCard() {
        Command c = new DrawCard(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
    }

    public void drawFestivalCard() {
        Command c = new DrawPalaceCard(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
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
        c.execute();
        commands.push(c);
    }
}
