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
    Stack<Command> commandStack;

    @Before
    public void setUp() throws Exception {
        gameFacade = new GameFacade(new String[]{"blue", "white", "black"});
        commandStack = new Stack<>();
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
        commandStack.push(new MoveDeveloper(gameFacade, 10));
        commandStack.push(new PlaceDeveloper(gameFacade, 10));
        commandStack.push(new RemoveDeveloper(gameFacade, 10));
        commandStack.push(new Rotate(gameFacade));
        commandStack.push(new TabDeveloper(gameFacade));
        commandStack.push(new SetRotation(gameFacade, new int[]{1, 2}));
    }

    @Test
    public void testSave() throws Exception {

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


        lineIn = new String[]{"model.commands.MoveDeveloper", "10"};
        command = fileController.determineCommand(lineIn, gameFacade);
        assertEquals(MoveDeveloper.class, command.getClass());


        lineIn = new String[]{"model.commands.PlaceDeveloper", "10"};
        command = fileController.determineCommand(lineIn, gameFacade);
        assertEquals(PlaceDeveloper.class, command.getClass());


        lineIn = new String[]{"model.commands.RemoveDeveloper", "10"};
        command = fileController.determineCommand(lineIn, gameFacade);
        assertEquals(RemoveDeveloper.class, command.getClass());


        lineIn = new String[]{"model.commands.Rotate"};
        command = fileController.determineCommand(lineIn, gameFacade);
        assertEquals(Rotate.class, command.getClass());


        lineIn = new String[]{"model.commands.TabDeveloper"};
        command = fileController.determineCommand(lineIn, gameFacade);
        assertEquals(TabDeveloper.class, command.getClass());

        lineIn = new String[]{"model.commands.SetRotation", "1", "2"};
        command = fileController.determineCommand(lineIn, gameFacade);
        assertEquals(SetRotation.class, command.getClass());

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
