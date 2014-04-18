package view;

import controller.AreaViewportController;
import model.Board;
import model.GameFacade;
import model.HexSpace;
import model.Location;
import model.state.State;
import model.state.Turn;
import view.keypressed.KeyPressed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class AreaViewport {
    final static Color COLOURBACK = Color.WHITE;

    public final static Color COLOURCELL = Color.ORANGE;

    public final static Color COLOURGRID = Color.BLACK;
    final static int EMPTY = 0;
    final static int BSIZE = 12; // board size.
    final static int HEXSIZE = 60; // hex size in pixels
    final static int BORDERS = 15;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3; // screen
    private Board board = new Board();
    private List<KeyPressed> keySet;
    private State state;

    public AreaViewport(GameFacade b, List<KeyPressed> keySet) {
        this.keySet = keySet;
        this.state = new Turn(b);
        initGame();
        createAndShowGUI();
    }

    void initGame() {

        AreaViewportController.setXYasVertex(false); // RECOMMENDED: leave this as FALSE.

        AreaViewportController.setHeight(HEXSIZE); // Either setHeight or setSize must be run
        AreaViewportController.setBorders(BORDERS);

        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                ((HexSpace) board.getSpace(new Location(i, j))).status = EMPTY;
            }
        }

        // set up board here
        ((HexSpace) board.getSpace(new Location(3, 3))).status = (int) 'A';
        ((HexSpace) board.getSpace(new Location(4, 3))).status = (int) 'Q';
        ((HexSpace) board.getSpace(new Location(4, 4))).status = -(int) 'B';
    }

    private void createAndShowGUI() {
        DrawingPanel panel = new DrawingPanel();

        JFrame frame = new JFrame("Hex Testing 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        frame.setFocusable(false);
        panel.setFocusable(true);
        content.add(panel);

        frame.setSize((int) (SCRSIZE / 1.23), SCRSIZE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class DrawingPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        public DrawingPanel() {
            setBackground(COLOURBACK);

            Location l = new Location(0, 0);

            List<KeyAdapter> keys = new ArrayList<KeyAdapter>();
            keys.add(new OneKey(l));
            keys.add(new TwoKey(l));
            keys.add(new ThreeKey(l));
            keys.add(new SevenKey(l));
            keys.add(new EightKey(l));
            keys.add(new NineKey(l));
            addListeners(keys);


            KeyPressedP keyPressedP = new KeyPressedP(l);
            KeyPressedV keyPressedV = new KeyPressedV(l);
            KeyPressedI keyPressedI = new KeyPressedI(l);
            KeyPressed1 keyPressed1 = new KeyPressed1();
            KeyPressed2 keyPressed2 = new KeyPressed2();
            KeyPressed3 keyPressed3 = new KeyPressed3();
            KeyPressed7 keyPressed7 = new KeyPressed7();
            KeyPressed8 keyPressed8 = new KeyPressed8();
            KeyPressed9 keyPressed9 = new KeyPressed9();
            KeyPressedTab keyPressedTab = new KeyPressedTab();
            KeyPressedR keyPressedR = new KeyPressedR();
            KeyPressedX keyPressedX = new KeyPressedX();
            KeyPressedA keyPressedA = new KeyPressedA();
            KeyPressedESC keyPressedESC = new KeyPressedESC();
            KeyPressedF keyPressedF = new KeyPressedF();
            KeyPressedU keyPressedU = new KeyPressedU();
            KeyPressedW keyPressedW = new KeyPressedW();
            KeyPressedE keyPressedE = new KeyPressedE();
            KeyPressed4 keyPressed4 = new KeyPressed4();
            KeyPressed6 keyPressed6 = new KeyPressed6();
            KeyPressedS keyPressedS = new KeyPressedS();

            addKeyListener(keyPressed1);
            addKeyListener(keyPressed2);
            addKeyListener(keyPressed3);
            addKeyListener(keyPressed7);
            addKeyListener(keyPressed8);
            addKeyListener(keyPressed9);
            addKeyListener(keyPressedTab);
            addKeyListener(keyPressedR);
            addKeyListener(keyPressedP);
            addKeyListener(keyPressedV);
            addKeyListener(keyPressedI);
            addKeyListener(keyPressedX);
            addKeyListener(keyPressedA);
            addKeyListener(keyPressedESC);
            addKeyListener(keyPressedF);
            addKeyListener(keyPressedU);
            addKeyListener(keyPressedW);
            addKeyListener(keyPressedE);
            addKeyListener(keyPressed4);
            addKeyListener(keyPressedS);
            addKeyListener(keyPressed6);
        }

        public void addListeners(List<KeyAdapter> keys) {
            for (KeyAdapter ka : keys) {
                addKeyListener(ka);
            }
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            super.paintComponent(g2);
            // draw grid
            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < BSIZE; j++) {
                    AreaViewportController.drawHex(i, j, g2);
                }
            }
            // fill in hexes
            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < BSIZE; j++) {
                    AreaViewportController.fillHex(i, j, ((HexSpace) board.getSpace(new Location(i, j))).status,
                            ((HexSpace) board.getSpace(new Location(i, j))).color, g2);
                }
            }
        }

        class OneKey extends KeyAdapter {
            private Location l;

            public OneKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                System.out.println(ke.getKeyChar());
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '1') {
                    if (x % 2 == 0)
                        p = new Point(x - 1, y);
                    else
                        p = new Point(x - 1, y + 1);
                    if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE)
                        return;
                    else {
                        x = p.x;
                        y = p.y;
                        System.out.println("LOC: " + x + " " + y + "");
                    }
                }
                l.setLocation(x, y);
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).status = (int) 'X';
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).color = Color.GREEN;
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }


        class TwoKey extends KeyAdapter {
            private Location l;

            public TwoKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                System.out.println(ke.getKeyChar());
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '2') {
                    p = new Point(x, y + 1);
                    if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE)
                        return;
                    else {
                        x = p.x;
                        y = p.y;
                        System.out.println("LOC: " + x + " " + y + "");
                    }
                }
                l.setLocation(x, y);
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).status = (int) 'X';
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).color = Color.GREEN;
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class ThreeKey extends KeyAdapter {
            private Location l;

            public ThreeKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                System.out.println(ke.getKeyChar());
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '3') {
                    if (x % 2 == 0)
                        p = new Point(x + 1, y);
                    else
                        p = new Point(x + 1, y + 1);
                    if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE)
                        return;
                    else {
                        x = p.x;
                        y = p.y;
                        System.out.println("LOC: " + x + " " + y + "");
                    }
                }
                l.setLocation(x, y);
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).status = (int) 'X';
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).color = Color.GREEN;
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class SevenKey extends KeyAdapter {
            private Location l;

            public SevenKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                System.out.println(ke.getKeyChar());
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '7') {
                    if (x % 2 == 0)
                        p = new Point(x - 1, y - 1);
                    else
                        p = new Point(x - 1, y);
                    if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE)
                        return;
                    else {
                        x = p.x;
                        y = p.y;
                        System.out.println("LOC: " + x + " " + y + "");
                    }
                }
                l.setLocation(x, y);
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).status = (int) 'X';
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).color = Color.GREEN;
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class EightKey extends KeyAdapter {
            private Location l;

            public EightKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                System.out.println(ke.getKeyChar());
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '8') {
                    p = new Point(x, y - 1);
                    if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE)
                        return;
                    else {
                        x = p.x;
                        y = p.y;
                        System.out.println("LOC: " + x + " " + y + "");
                    }
                }
                l.setLocation(x, y);
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).status = (int) 'X';
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).color = Color.GREEN;
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class NineKey extends KeyAdapter {
            private Location l;

            public NineKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                System.out.println(ke.getKeyChar());
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '9') {
                    if (x % 2 == 0)
                        p = new Point(x + 1, y - 1);
                    else
                        p = new Point(x + 1, y);
                    if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE)
                        return;
                    else {
                        x = p.x;
                        y = p.y;
                        System.out.println("LOC: " + x + " " + y + "");
                    }
                }
                l.setLocation(x, y);
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).status = (int) 'X';
                ((HexSpace) board.getSpace(new Location(p.x, p.y))).color = Color.GREEN;
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressed1 extends KeyAdapter {

            public KeyPressed1() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '1') {
                    state.keyPressed1();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressed2 extends KeyAdapter {

            public KeyPressed2() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '2') {
                    state.keyPressed2();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressed3 extends KeyAdapter {

            public KeyPressed3() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '3') {
                    state.keyPressed3();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressed7 extends KeyAdapter {

            public KeyPressed7() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '7') {
                    state.keyPressed7();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressed8 extends KeyAdapter {

            public KeyPressed8() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '8') {
                    state.keyPressed8();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressed9 extends KeyAdapter {

            public KeyPressed9() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '9') {
                    state.keyPressed9();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedTab extends KeyAdapter {

            public KeyPressedTab() {

            }

            public void keyTyped(KeyEvent ke) {
                if (KeyEvent.VK_TAB == ke.getKeyCode()) {
                    state.keyPressedTab();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedR extends KeyAdapter {

            public KeyPressedR() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'r') {
                    state.keyPressedR();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedX extends KeyAdapter {

            public KeyPressedX() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'x') {
                    state.keyPressedX();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedA extends KeyAdapter {

            public KeyPressedA() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'a') {
                    state.keyPressedA();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedESC extends KeyAdapter {

            public KeyPressedESC() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    state.keyPressedESC();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedF extends KeyAdapter {

            public KeyPressedF() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'f') {
                    state.keyPressedF();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedU extends KeyAdapter {

            public KeyPressedU() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'u') {
                    state.keyPressedU();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedW extends KeyAdapter {

            public KeyPressedW() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'w') {
                    state.keyPressedW();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedE extends KeyAdapter {

            public KeyPressedE() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'e') {
                    state.keyPressedE();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressed4 extends KeyAdapter {

            public KeyPressed4() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '4') {
                    state.keyPressed4();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressed6 extends KeyAdapter {

            public KeyPressed6() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '6') {
                    state.keyPressed6();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedS extends KeyAdapter {

            public KeyPressedS() {

            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 's') {
                    state.keyPressedS();
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedP extends KeyAdapter {
            private Location l;

            public KeyPressedP(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'p') {
                    state.keyPressedP(l);
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedV extends KeyAdapter {
            private Location l;

            public KeyPressedV(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'v') {
                    state.keyPressedV(l);
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class KeyPressedI extends KeyAdapter {
            private Location l;

            public KeyPressedI(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'i') {
                    state.keyPressedI(l);
                }
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        // end of MyMouseListener class
    } // end of DrawingPanel class
}