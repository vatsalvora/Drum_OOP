package controller;

import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.Player;
import model.commands.*;

import java.io.*;
import java.util.Stack;

/**
 * Created by devan on 4/19/14.
 */
public class FileController {


    public void save(String fileName, Stack<Command> commands, GameFacade gameFacade) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(fileName);
            Player[] names = gameFacade.getPlayers();
            writer.println(names.length);
            for (Player player : names) {
                writer.println(player.getColor());
            }
            for (Command comm : commands) {
                writer.println(comm);
            }
            writer.close();
            System.out.println("File saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String[] colors = loadColors(br);
            GameFacade gameFacade = new GameFacade(colors);
            loadCommands(br, gameFacade);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
    }

    public void loadCommands(BufferedReader br, GameFacade gameFacade) {
        try {
            while (br.readLine() != null) {
                String[] lineIn = br.readLine().split(" ");
                Command command = determineCommand(lineIn, gameFacade);
                command.execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Command determineCommand(String[] lineIn, GameFacade gameFacade) {
        String command = lineIn[0];
        String modelCommand = "model.commands.";
        if (command.contains("model.ChangeTurn")) {
            return new ChangeTurn(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "endpalacefestival")) {
            return new EndPalaceFestival(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "initiatepalacefesitival")) {
            return new InitiatePalaceFestival(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "placedoublelandtile")) {
            int points = Integer.parseInt(lineIn[1]);
            return new PlaceDoubleLandTile(gameFacade, points);
        } else if (command.equalsIgnoreCase(modelCommand + "placetriplelandtile")) {
            int points = Integer.parseInt(lineIn[1]);
            return new PlaceTripleLandTile(gameFacade, points);
        } else if (command.equalsIgnoreCase(modelCommand + "placeirrigationtile")) {
            int points = Integer.parseInt(lineIn[1]);
            return new PlaceIrrigationTile(gameFacade, points);
        } else if (command.equalsIgnoreCase(modelCommand + "placepalacetile")) {
            int points = Integer.parseInt(lineIn[1]);
            return new PlacePalaceTile(gameFacade, points);
        } else if (command.equalsIgnoreCase(modelCommand + "placericetile")) {
            int points = Integer.parseInt(lineIn[1]);
            return new PlaceRiceTile(gameFacade, points);
        } else if (command.equalsIgnoreCase(modelCommand + "placevillagetile")) {
            int points = Integer.parseInt(lineIn[1]);
            return new PlaceVillageTile(gameFacade, points);
        } else if (command.equalsIgnoreCase(modelCommand + "move1")) {
            return new Move1(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "move2")) {
            return new Move2(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "move3")) {
            return new Move3(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "move7")) {
            return new Move7(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "move8")) {
            return new Move8(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "move9")) {
            return new Move9(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "drawcard")) {
            return new DrawCard(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "drawpalacecard")) {
            return new DrawPalaceCard(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "rotate")) {
            return new Rotate(gameFacade);
        } else if (command.equalsIgnoreCase(modelCommand + "useactiontoken")) {
            return new UseActionToken(gameFacade);
        } else {
            return null;
        }
    }

    public String[] loadColors(BufferedReader br) {
        String[] colors = new String[0];
        try {
            int numPlayers = Integer.parseInt(br.readLine());
            colors = new String[numPlayers];
            for (int i = 0; i < numPlayers; i++) {
                colors[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return colors;
    }


}
