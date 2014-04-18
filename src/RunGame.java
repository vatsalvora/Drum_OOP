import model.GameFacade;
import model.Location;
import model.state.State;
import model.state.Turn;
import view.AreaViewport;
import view.keypressed.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RunGame {
    public static void main(String[] args) {
        String[] names = { "Lucas", "Bob", "Billy" };

        final GameFacade b = new GameFacade(names);
        final List<KeyPressed> keySet = createListeners(b);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AreaViewport(b, keySet);
            }
        });
    }

    public static List<KeyPressed> createListeners(GameFacade b){
        State state = new Turn(b);
        Location l = new Location(0,0);
        List<KeyPressed> keySet = new ArrayList<KeyPressed>();

        keySet.add(new KeyPressed1(l, state));
        keySet.add(new KeyPressed2(l, state));
        keySet.add(new KeyPressed3(l, state));
        keySet.add(new KeyPressed7(l, state));
        keySet.add(new KeyPressed8(l, state));
        keySet.add(new KeyPressed9(l, state));
        keySet.add(new KeyPressedTab(l, state));
        keySet.add(new KeyPressedR(l, state));
        keySet.add(new KeyPressedP(l, state));
        keySet.add(new KeyPressedV(l, state));
        keySet.add(new KeyPressedI(l, state));
        keySet.add(new KeyPressedX(l, state));
        keySet.add(new KeyPressedA(l, state));
        keySet.add(new KeyPressedESC(l, state));
        keySet.add(new KeyPressedF(l, state));
        keySet.add(new KeyPressedU(l, state));
        keySet.add(new KeyPressedW(l, state));
        keySet.add(new KeyPressedE(l, state));
        keySet.add(new KeyPressed4(l, state));
        keySet.add(new KeyPressed6(l, state));
        keySet.add(new KeyPressedS(l, state));
        return keySet;
    }
}