package controller;

import model.Command;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

}
