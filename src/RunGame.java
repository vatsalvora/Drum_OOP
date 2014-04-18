import model.GameFacade;
import model.Location;
import model.state.State;
import model.state.Turn;
import view.hexgame;
import view.keypressed.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RunGame {
    public static void main(String[] args) {
        String[] names = { "Lucas", "Bob", "Billy" };

        final GameFacade b = new GameFacade(names);
        final List<KeyPressed> keyset = createListeners(b);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new hexgame(b, keyset);
            }
        });
    }

    public static List<KeyPressed> createListeners(GameFacade b){
        State state = new Turn(b);
        Location l = new Location(0,0);
        List<KeyPressed> keyset = new ArrayList<KeyPressed>();

        keyset.add(new KeyPressed1(l, state));
        keyset.add(new KeyPressed2(l, state));
        keyset.add(new KeyPressed3(l, state));
        keyset.add(new KeyPressed7(l, state));
        keyset.add(new KeyPressed8(l, state));
        keyset.add(new KeyPressed9(l, state));
        keyset.add(new KeyPressedTab(l, state));
        keyset.add(new KeyPressedR(l, state));
        keyset.add(new KeyPressedP(l, state));
        keyset.add(new KeyPressedV(l, state));
        keyset.add(new KeyPressedI(l, state));
        keyset.add(new KeyPressedX(l, state));
        keyset.add(new KeyPressedA(l, state));
        keyset.add(new KeyPressedESC(l, state));
        keyset.add(new KeyPressedF(l, state));
        keyset.add(new KeyPressedU(l, state));
        keyset.add(new KeyPressedW(l, state));
        keyset.add(new KeyPressedE(l, state));
        keyset.add(new KeyPressed4(l, state));
        keyset.add(new KeyPressed6(l, state));
        keyset.add(new KeyPressedS(l, state));
        return keyset;
    }
}