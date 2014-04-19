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
    public static String EMPTY = "";
    public static int BOARD_SIZE = 12; // board size.
    public static int HEX_SIZE = 46; // hex size in pixels
    public static int BORDERS = 15;
    public static int SCREEN_Width = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3; // screen
    public static int SCREEN_LEN = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3;
    public static Color movement;
    private State state;
    private DrawingPanel panel;

    public AreaViewport(Board board) {
        BOARD_SIZE = board.getWidth();
        int maxLen = board.getMaxLen();
        movement = Color.BLUE;
        SCREEN_Width = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3;
        SCREEN_LEN = HEX_SIZE * (maxLen + 1) + BORDERS * 3;

        initGame(board);
        createAndShowGUI(board);
    }

    public void initGame(Board board) {

        AreaViewportController.setXYasVertex(false); // RECOMMENDED: leave this as FALSE.

        AreaViewportController.setHeight(HEX_SIZE); // Either setHeight or setSize must be run
        AreaViewportController.setBorders(BORDERS);


        // set up board here

        ((HexSpace) board.getSpace(new Location(3, 3))).color = Color.BLUE;
        ((HexSpace) board.getSpace(new Location(5, 8))).color = Color.BLUE;
        ((HexSpace) board.getSpace(new Location(3, 15))).color = Color.BLUE;
    }

    private void createAndShowGUI(Board board) {
        panel = new DrawingPanel(board);
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

    public void setMovement(Color color){
        movement = color;
    }
    public void render(Board board){
        panel.repaint();
    }

    public void addKeyListeners(List<KeyPressed> keySet){
        panel.addListeners(keySet);
    }

    class DrawingPanel extends JPanel {

        private Board board;
        private static final long serialVersionUID = 1L;

        public DrawingPanel(Board board) {
            this.board = board;
            setBackground(COLOR_BACK);

        }
        public void setBoard(Board board){
            this.board = board;
        }

        public void setNode(HexSpace node) {
            board.setCurrentSpace(node);
        }

        public HexSpace getNode() {
            return board.getCurrentSpace();
        }

        public void addListeners(List<KeyPressed> keySet) {
            for (KeyPressed kp : keySet) {
                addKeyListener(kp);
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
                    String status = (curr.getHeight()>0) ? curr.getHeight()+"" : "";
                    Color color = (curr.equals(board.getCurrentSpace())) ? movement : curr.color;
                    AreaViewportController.fillHex(loc.getXLocation(), loc.getYLocation(), status,
                            color, g2);
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
                    state.keyPressedP();
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