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

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AreaViewport {
    public Color COLOR_BACK = Color.WHITE;

    public static Color COLOR_CELL = Color.ORANGE;

    public static Color COLOR_GRID = Color.BLACK;
    public static int EMPTY = 0;
    public static int BOARD_SIZE = 12; // board size.
    public static int HEX_SIZE = 46; // hex size in pixels
    public static int BORDERS = 15;
    public static int SCREEN_Width = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3; // screen
    public static int SCREEN_LEN = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3;
    private Board board = new Board();
    private List<KeyPressed> keySet;
    private State state;

    public AreaViewport(GameFacade b, List<KeyPressed> keySet) {
        this.keySet = keySet;
        this.state = new Turn(b);
        BOARD_SIZE = board.getWidth();
        int maxLen = board.getMaxLen();
        SCREEN_Width = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3;
        SCREEN_LEN = HEX_SIZE * (maxLen + 1) + BORDERS * 3;

        initGame();
        createAndShowGUI();
    }

    void initGame() {

        AreaViewportController.setXYasVertex(false); // RECOMMENDED: leave this as FALSE.

        AreaViewportController.setHeight(HEX_SIZE); // Either setHeight or setSize must be run
        AreaViewportController.setBorders(BORDERS);

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < board.getLength(i); j++) {
                try {
                    ((HexSpace) board.getSpace(new Location(j, i))).status = EMPTY;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(i);
                    System.exit(1);
                }
            }
        }

        // set up board here
        ((HexSpace) board.getSpace(new Location(3, 3))).status = (int) 'I';
        ((HexSpace) board.getSpace(new Location(5, 8))).status = (int) 'I';
        ((HexSpace) board.getSpace(new Location(3, 15))).status = (int) 'I';
    }

    private void createAndShowGUI() {
        DrawingPanel panel = new DrawingPanel();

        JFrame frame = new JFrame("Hex Testing 4");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        frame.setFocusable(false);
        panel.setFocusable(true);
        content.add(panel);

        frame.setSize((int) (SCREEN_Width / 1.23), (int)(SCREEN_LEN*1.05));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class DrawingPanel extends JPanel {

        private HexSpace root;
        private static final long serialVersionUID = 1L;

        public DrawingPanel() {
            setBackground(COLOR_BACK);

            Location l = new Location(0, 0);
            root = (HexSpace) board.getSpace(l);

            List<KeyAdapter> keys = new ArrayList<KeyAdapter>();
            keys.add(new OneKey());
            keys.add(new TwoKey());
            keys.add(new ThreeKey());
            keys.add(new SevenKey());
            keys.add(new EightKey());
            keys.add(new NineKey());
            keys.add(new PKey(l));
            keys.add(new EnterKey(l));
            addListeners(keys);
            //addListeners();

        }

        public void setNode(HexSpace node) {
            this.root = node;
        }

        public HexSpace getNode() {
            return root;
        }

        public void addListeners() {
            for (KeyPressed kp : keySet) {
                addKeyListener(kp);
            }
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
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < board.getLength(i); j++) {
                    HexSpace curr = (HexSpace) board.getSpace(new Location(j, i));
                    Location loc = curr.getLocation();
                    AreaViewportController.drawHex(loc.getXLocation(), loc.getYLocation(), g2);
                }
            }
            // fill in hexes
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < board.getLength(i); j++) {
                    // if (board[i][j] < 0)
                    // AreaViewportController.fillHex(i,j,COLOR_ONE,-board[i][j],g2);
                    // if (board[i][j] > 0) AreaViewportController.fillHex(i,j,COLOR_TWO,
                    // board[i][j],g2);
                    HexSpace curr = (HexSpace) board.getSpace(new Location(j, i));
                    Location loc = curr.getLocation();
                    AreaViewportController.fillHex(loc.getXLocation(), loc.getYLocation(), curr.status,
                            curr.color, g2);
                }
            }

            // g.setColor(Color.RED);
            // g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);
        }

        class PKey extends KeyAdapter {
            private Location l;

            public PKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {

                if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
                    state.keyPressedP(l);
                }
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class EnterKey extends KeyAdapter {
            private Location l;

            public EnterKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {

                if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
                    state.keyPressedEnter();
                }
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class OneKey extends KeyAdapter {
            public OneKey() {
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '1') {
                    System.out.println(ke.getKeyChar());
                    if (getNode().getNeighbor(0) != null) {
                        HexSpace neighbor = (HexSpace) getNode().getNeighbor(0);
                        neighbor.status = (int) 'X';
                        neighbor.color = Color.RED;
                        System.out.println("LOC: " + neighbor.getLocation());
                        setNode(neighbor);
                    }
                }
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }


        class TwoKey extends KeyAdapter {

            public TwoKey() {
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '2') {
                    System.out.println(ke.getKeyChar());
                    if (getNode().getNeighbor(1) != null) {
                        HexSpace neighbor = (HexSpace) getNode().getNeighbor(1);
                        neighbor.status = (int) 'X';
                        neighbor.color = Color.CYAN;
                        System.out.println("LOC: " + neighbor.getLocation());
                        setNode(neighbor);
                    }
                }
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class ThreeKey extends KeyAdapter {
            public ThreeKey() {
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '3') {
                    System.out.println(ke.getKeyChar());
                    if (getNode().getNeighbor(2) != null) {
                        HexSpace neighbor = (HexSpace) getNode().getNeighbor(2);
                        neighbor.status = (int) 'X';
                        neighbor.color = Color.GREEN;
                        System.out.println("LOC: " + neighbor.getLocation());
                        setNode(neighbor);
                    }
                }
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class SevenKey extends KeyAdapter {
            public SevenKey() {
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '7') {
                    System.out.println(ke.getKeyChar());
                    if(getNode().getNeighbor(3) != null)
                    {
                        HexSpace neighbor = (HexSpace)getNode().getNeighbor(3);
                        neighbor.status = (int) 'X';
                        neighbor.color = Color.WHITE;
                        System.out.println("LOC: " + neighbor.getLocation());
                        setNode(neighbor);
                    }
                }
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class EightKey extends KeyAdapter {

            public EightKey() {
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '8') {
                    System.out.println(ke.getKeyChar());
                    System.out.println(getNode().numberOfNeighbors());
                    if (getNode().getNeighbor(4) != null) {
                        HexSpace neighbor = (HexSpace) getNode().getNeighbor(4);
                        neighbor.status = (int) 'X';
                        neighbor.color = Color.BLUE;
                        System.out.println("LOC: " + neighbor.getLocation());
                        setNode(neighbor);
                    }
                }
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        class NineKey extends KeyAdapter {
            public NineKey() {
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '9') {
                    System.out.println(ke.getKeyChar());
                    if (getNode().getNeighbor(5) != null) {
                        HexSpace neighbor = (HexSpace) getNode().getNeighbor(5);
                        neighbor.status = (int) 'X';
                        neighbor.color = Color.GRAY;
                        System.out.println("LOC: " + neighbor.getLocation());
                        setNode(neighbor);
                    }
                }
                repaint();
            }

            public void keyPressed(KeyEvent ke) {

            }

            public void keyReleased(KeyEvent ke) {

            }
        }

        // end of MyMouseListener class
    } // end of DrawingPanel class
}