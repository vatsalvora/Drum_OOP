import model.GameFacade;
import model.Location;
import model.state.State;
import model.state.Turn;
import view.keypressed.*;

import java.util.ArrayList;
import java.util.List;

public class RunGame {
    public static void main(String[] args) {
        String[] names = {"Lucas", "Bob", "Billy"};

        GameFacade b = new GameFacade(names);
        List<KeyPressed> keySet = createListeners(b);
        b.addKeyListeners(keySet);
    }

    public static List<KeyPressed> createListeners(GameFacade b) {
        State state = new Turn(b);
        Location l = new Location(0, 0);
        List<KeyPressed> keySet = new ArrayList<KeyPressed>();

        keySet.add(new KeyPressed1(state));
        keySet.add(new KeyPressed2(state));
        keySet.add(new KeyPressed3(state));
        keySet.add(new KeyPressed7(state));
        keySet.add(new KeyPressed8(state));
        keySet.add(new KeyPressed9(state));
        keySet.add(new KeyPressedTab(state));
        keySet.add(new KeyPressedR(state));
        keySet.add(new KeyPressedP(state));
        keySet.add(new KeyPressedV(state));
        keySet.add(new KeyPressedI(state));
        keySet.add(new KeyPressedX(state));
        keySet.add(new KeyPressedA(state));
        keySet.add(new KeyPressedESC(state));
        keySet.add(new KeyPressedF(state));
        keySet.add(new KeyPressedU(state));
        keySet.add(new KeyPressedW(state));
        keySet.add(new KeyPressedE(state));
        keySet.add(new KeyPressed4(state));
        keySet.add(new KeyPressed6(state));
        keySet.add(new KeyPressedS(state));
        keySet.add(new KeyPressedEnter(state));
        keySet.add(new KeyPressedSpace(state));
        keySet.add(new KeyPressedT(state));
        keySet.add(new KeyPressedC(state));
        keySet.add(new KeyPressedM(state));
        keySet.add(new KeyPressedJ(state));
        keySet.add(new KeyPressedK(state));
        return keySet;
    }

}