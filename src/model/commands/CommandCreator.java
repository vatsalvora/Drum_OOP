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
    private Color cornflower_blue = new Color(100, 149, 237);

    public CommandCreator(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    public void placeDoubleLandTile() {
        Command c = new SetRotation(gameFacade, new int[]{2});
        c.execute();
        commands.push(c);
        Command m = new ChangeMovementColor(gameFacade,Color.GREEN,Color.GREEN);
        m.execute();
        commands.push(m);
        Command p = new ChangeLvlDisplay(gameFacade,0);
        p.execute();
        commands.push(p);
        current = new PlaceDoubleLandTile(gameFacade);
    }

    public void execute() {
        current.execute();
        if (current.save()) {
            commands.push(current);
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
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
        if(current instanceof MoveDeveloper)
        {
            try {
                gameFacade.createPath();
            }
            catch(Exception e)
            {
                //do nothing with exception
            }
        }
    }

    public void move2() {
        Command c = new Move2(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
        if(current instanceof MoveDeveloper)
        {
            try {
                gameFacade.createPath();
            }
            catch(Exception e)
            {
                //do nothing with exception
            }
        }
    }

    public void move3() {
        Command c = new Move3(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
        if(current instanceof MoveDeveloper)
        {
            try {
                gameFacade.createPath();
            }
            catch(Exception e)
            {
                //do nothing with exception
            }
        }
    }

    public void move7() {
        Command c = new Move7(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
        if(current instanceof MoveDeveloper)
        {
            try {
                gameFacade.createPath();
            }
            catch(Exception e)
            {
                //do nothing with exception
            }
        }
    }

    public void move8() {
        Command c = new Move8(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
        if(current instanceof MoveDeveloper)
        {
            try {
                gameFacade.createPath();
            }
            catch(Exception e)
            {
                //do nothing with exception
            }
        }
    }

    public void move9() {
        Command c = new Move9(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
        }
        if(current instanceof MoveDeveloper)
        {
            try {
                gameFacade.createPath();
            }
            catch(Exception e)
            {
                //do nothing with exception
            }
        }
    }

    public void placeTripleLandTile() {
        Command c = new SetRotation(gameFacade, new int[]{2,3});
        c.execute();
        commands.push(c);
        Command m = new ChangeMovementColor(gameFacade,Color.MAGENTA,Color.MAGENTA);
        m.execute();
        commands.push(m);
        Command p = new ChangeLvlDisplay(gameFacade,0);
        p.execute();
        commands.push(p);
        current = new PlaceTripleLandTile(gameFacade);

    }

    public void placeIrrigationTile() {
        Command r = new SetRotation(gameFacade, new int[0]);
        r.execute();
        commands.push(r);
        Command m = new ChangeMovementColor(gameFacade,Color.BLUE,Color.BLUE);
        m.execute();
        commands.push(m);
        Command p = new ChangeLvlDisplay(gameFacade,0);
        p.execute();
        commands.push(p);
        current = new PlaceIrrigationTile(gameFacade);

    }

    public void placeRiceTile() {
        Command r = new SetRotation(gameFacade, new int[0]);
        r.execute();
        commands.push(r);
        Command m = new ChangeMovementColor(gameFacade,Color.GREEN,Color.GREEN);
        m.execute();
        commands.push(m);
        Command p = new ChangeLvlDisplay(gameFacade,0);
        p.execute();
        commands.push(p);
        current = new PlaceRiceTile(gameFacade);

    }

    public void placeVillageTile() {
        Command r = new SetRotation(gameFacade, new int[0]);
        r.execute();
        commands.push(r);
        Command m = new ChangeMovementColor(gameFacade,Color.RED,Color.RED);
        m.execute();
        commands.push(m);
        Command p = new ChangeLvlDisplay(gameFacade,0);
        p.execute();
        commands.push(p);
        current = new PlaceVillageTile(gameFacade);

    }

    public void placePalaceTile() {
        Command r = new SetRotation(gameFacade, new int[0]);
        r.execute();
        commands.push(r);
        Command m = new ChangeMovementColor(gameFacade,Color.YELLOW,Color.YELLOW);
        m.execute();
        commands.push(m);

        int lvl = gameFacade.getPalaceLvl();
        if(lvl<=8) lvl+=2;

        Command p = new ChangeLvlDisplay(gameFacade,lvl);
        p.execute();
        commands.push(p);

        current = new PlacePalaceTile(gameFacade, lvl);

    }

    public void upgradePalaceTile() {
        Command r = new SetRotation(gameFacade, new int[0]);
        r.execute();
        commands.push(r);
        Command m = new ChangeMovementColor(gameFacade,Color.YELLOW,Color.YELLOW);
        m.execute();
        commands.push(m);
        PalaceTile pt = (PalaceTile)gameFacade.getCurrentSpace().getTopTile();
        if(pt != null){
            int lvl = gameFacade.getPalaceLvl();
            if(pt.getLvl() > lvl) lvl = pt.getLvl();
            if(lvl <=8) lvl += 2;
            Command p = new ChangeLvlDisplay(gameFacade,lvl);
            p.execute();
            commands.push(p);
            current = new PlacePalaceTile(gameFacade, lvl);

        }
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
        Command m = new ChangeMovementColor(gameFacade,gameFacade.getCurrentPlayerColor(),cornflower_blue);
        m.execute();
        commands.push(m);
        Command r = new SetRotation(gameFacade, new int[0]);
        r.execute();
        commands.push(r);
        Command p = new ChangeLvlDisplay(gameFacade,0);
        p.execute();
        commands.push(p);
        current = new PlaceDeveloper(gameFacade);
    }

    public void removeDeveloper()
    {
        current = new RemoveDeveloper(gameFacade);
    }


    public void selectDeveloper() {
        Command m = new ChangeMovementColor(gameFacade,gameFacade.getCurrentPlayerColor(),cornflower_blue);
        m.execute();
        commands.push(m);
        Command r = new SetRotation(gameFacade, new int[0]);
        r.execute();
        commands.push(r);
        Command p = new ChangeLvlDisplay(gameFacade,0);
        p.execute();
        Command c = new SelectDeveloper(gameFacade);
        c.execute();
        if (c.save()) {
            commands.push(c);
            current = new MoveDeveloper(gameFacade);
        } else {
            current = null;
        }
    }

    public void undoAll(){
        while(!commands.empty()){
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
        if (c.save()) {
            commands.push(c);
        }
    }
}
