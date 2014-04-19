package controller;

import model.ChangeTurn;
import model.Command;
import model.Location;
import model.commands.CommandCreator;

import java.io.*;
import java.util.Stack;

/**
 * Created by devan on 4/19/14.
 */
public class FileController {


    public void save(String fileName, Stack<Command> commands) {
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

    public CommandCreator loadCommandCreator(String fileName) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileName));

            while (br.readLine() != null) {
                String[] lineIn = br.readLine().split(" ");
                String command = lineIn[0];
                Location location = new Location(Integer.parseInt(lineIn[0]), Integer.parseInt(lineIn[0]));


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
        return null;
    }

    public Command determineCommand(String command, Location location) {
        if (command.equalsIgnoreCase("changeturn")) {

        } else if (command.equalsIgnoreCase("endpalacefestival")) {

        } else if (command.equalsIgnoreCase("initiatepalacefesitival")) {

        } else if (command.equalsIgnoreCase("placedoublelandtile")) {

        } else if (command.equalsIgnoreCase("placetriplelandtile")) {

        } else if (command.equalsIgnoreCase("placeirrigationtile")) {

        } else if (command.equalsIgnoreCase("placepalacetile")) {

        } else if (command.equalsIgnoreCase("placericetile")) {

        } else if (command.equalsIgnoreCase("placevillagetile")) {
        } else {

        }
        return null;

    }

}
