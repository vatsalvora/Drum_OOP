package view;

import controller.AreaViewportController;
import model.*;
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
    public Color COLOR_BACK = Color.WHITE;

    public  Color COLOR_CELL = Color.ORANGE;

    public  Color COLOR_GRID = Color.BLACK;
    public  String EMPTY = "";
    public  int BOARD_SIZE = 12; // board size.
    public  int HEX_SIZE = 46; // hex size in pixels
    public  int BORDERS = 15;
    public  int SCREEN_Width = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3; // screen
    public  int SCREEN_LEN = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3;
    public  boolean XYVertex = true;  // true: x,y are the coords of the first vertex.
    // false: x,y are the coords of the top left rect. co-ord.

    //private  int BORDERS = 50; // default number of pixels for the border.

    private  int s = 0; // length of one side
    private  int t = 0; // short side of 30o triangle outside of each hex
    private  int r = 0; // radius of inscribed circle (centre to middle of
    // each side). r= h/2
    private  int h = 0; // height. Distance between centres of two
    // adjacent hexes. Distance between two opposite
    // sides in a hex.
    public  Color movement;
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


    public  void setXYasVertex(boolean b) {
        XYVertex = b;
    }

    public  void setBorders(int b) {
        BORDERS = b;
    }


//    }
    public  void setHeight(int height) {
        h = height; // h = basic dimension: height (distance between two adj
        // centers aka size)
        r = h / 2; // r = radius of inscribed circle
        s = (int) (h / 1.73205); // s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h /
        // sqrt(3)
        t = (int) (r / 1.73205); // t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2
        // sqrt(3)) = r / sqrt(3)
    }


    public  Polygon hex(int x0, int y0) {

        int y = y0 + BORDERS;
        int x = x0 + BORDERS;

        if (s == 0 || h == 0) {
            System.out.println("ERROR: size of hex has not been set");
            return new Polygon();
        }

        int[] cx, cy;

        if (XYVertex)
            cx = new int[]{x, x + s, x + s + t, x + s, x, x - t}; // this is for the top left vertex being at x,y. Which
        else
            cx = new int[]{x + t, x + s + t, x + s + t + t, x + s + t, x + t, x}; // this is for the whole hexagon


        cy = new int[]{y, y, y + r, y + r + r, y + r + r, y + r};
        return new Polygon(cx, cy, 6);

    }


    public  void drawHex(int i, int j, Graphics2D g2) {
        int x = i * (s + t);
        int y = j * h + (i % 2) * h / 2;
        Polygon poly = hex(x, y);
        g2.setColor(COLOR_CELL);
        g2.fillPolygon(poly);
        g2.setColor(COLOR_GRID);
        g2.drawPolygon(poly);
    }


    public  void fillHex(int i, int j, String n, Color color, Graphics2D g2) {
        char c;
        int x = i * (s + t);
        int y = j * h + (i % 2) * h / 2;
        Polygon poly = hex(x, y);
        g2.setColor(color);
        g2.fillPolygon(poly);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(poly);
        g2.drawString("" + n, x + r + BORDERS, y + r + BORDERS + 4);
    }
    public void initGame(Board board) {

        setXYasVertex(false); // RECOMMENDED: leave this as FALSE.

        setHeight(HEX_SIZE); // Either setHeight or setSize must be run
        setBorders(BORDERS);


        // set up board here
        Tile t1 = new IrrigationTile();
        Tile t2 = new IrrigationTile();
        Tile t3 = new IrrigationTile();
        ((HexSpace) board.getSpace(new Location(3, 3))).place(t1);
        ((HexSpace) board.getSpace(new Location(5, 8))).place(t2);
        ((HexSpace) board.getSpace(new Location(3, 15))).place(t3);
    }

    private void createAndShowGUI(Board board) {
        panel = new DrawingPanel(board);
        JFrame frame = new JFrame("Hex Testing 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        private  final long serialVersionUID = 1L;

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
                    drawHex(loc.getXLocation(), loc.getYLocation(), g2);
                }
            }
            // fill in hexes
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < board.getLength(i); j++) {

                    HexSpace curr = (HexSpace) board.getSpace(new Location(j, i));
                    Location loc = curr.getLocation();
                    String status = (curr.getHeight()>0) ? curr.getHeight()+"" : "";
                    Color color = (curr.equals(board.getCurrentSpace())) ? movement : curr.getColor();
                    fillHex(loc.getXLocation(), loc.getYLocation(), status,
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