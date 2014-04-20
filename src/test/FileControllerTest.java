package test;

import controller.FileController;
import model.ChangeTurn;
import model.Command;
import model.GameFacade;
import model.commands.*;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by devan on 4/20/14.
 */
public class FileControllerTest {
    String fileName = "test1.txt";
    GameFacade gameFacade;

    @Before
    public void setUp() throws Exception {
        gameFacade = new GameFacade(new String[]{"blue", "white", "black"});
    }

    @Test
    public void testSave() throws Exception {
        Stack<Command> commandStack = new Stack<Command>();
        commandStack.push(new ChangeTurn(gameFacade));
        commandStack.push(new DrawCard(gameFacade));
        commandStack.push(new DrawPalaceCard(gameFacade));
        commandStack.push(new EndPalaceFestival(gameFacade));
        commandStack.push(new InitiatePalaceFestival(gameFacade));
        commandStack.push(new Move1(gameFacade));
        commandStack.push(new Move2(gameFacade));
        commandStack.push(new Move3(gameFacade));
        commandStack.push(new Move7(gameFacade));
        commandStack.push(new Move8(gameFacade));
        commandStack.push(new Move9(gameFacade));
        commandStack.push(new PlaceVillageTile(gameFacade));
        new FileController().save(fileName, commandStack, gameFacade);
    }

    @Test
    public void testLoad() throws Exception {

    }

    @Test
    public void testLoadCommands() throws Exception {
        FileController fileController = new FileController();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        gameFacade = new GameFacade(fileController.loadColors(br));
        fileController.loadCommands(br, gameFacade);
    }

    @Test
    public void testDetermineCommand() throws Exception {
        FileController fileController = new FileController();
        String[] lineIn = {"model.ChangeTurn@729e6e1a"};
        Command command = fileController.determineCommand(lineIn, gameFacade);
        assertEquals(ChangeTurn.class, command.getClass());

        lineIn = new String[]{"model.commands.PlaceVillageTile", "0"};
        command = fileController.determineCommand(lineIn, gameFacade);
        assertEquals(PlaceVillageTile.class, command.getClass());

    }

    @Test
    public void testLoadColors() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String[] colors = new FileController().loadColors(br);
        assertEquals("red", colors[0]);
        assertEquals("blue", colors[1]);
        assertEquals("green", colors[2]);
    }
}
