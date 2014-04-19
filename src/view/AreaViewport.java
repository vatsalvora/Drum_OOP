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
    public Color COLOURBACK = Color.WHITE;

    public static Color COLOURCELL = Color.ORANGE;

    public static Color COLOURGRID = Color.BLACK;
    public static int EMPTY = 0;
    public static int BSIZE = 12; // board size.
    public static int HEXSIZE = 46; // hex size in pixels
    public static int BORDERS = 15;
    public static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3; // screen
    private Board board = new Board();
    private List<KeyPressed> keySet;
    private State state;

    public AreaViewport(GameFacade b, List<KeyPressed> keySet) {
        this.keySet = keySet;
        this.state = new Turn(b);
        BSIZE = board.getWidth();
        SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3;

        initGame();
        createAndShowGUI();
    }

    void initGame() {

        AreaViewportController.setXYasVertex(false); // RECOMMENDED: leave this as FALSE.

        AreaViewportController.setHeight(HEXSIZE); // Either setHeight or setSize must be run
        AreaViewportController.setBorders(BORDERS);

        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < board.getLength(i); j++) {
                try {
                    ((HexSpace) board.getSpace(new Location(j, i))).status = EMPTY;
                }
                catch (Exception e){
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
        /**
         *
         */
        private HexSpace root;
        private static final long serialVersionUID = 1L;

        // mouse variables here
        // Point mPt = new Point(0,0);

        public DrawingPanel() {
            setBackground(COLOURBACK);

            Location l = new Location(0, 0);
            root = (HexSpace)board.getSpace(l);

            List<KeyAdapter> keys = new ArrayList<KeyAdapter>();
            keys.add(new OneKey());
            keys.add(new TwoKey());
            keys.add(new ThreeKey());
            keys.add(new SevenKey(l));
            keys.add(new EightKey());
            keys.add(new NineKey());
            keys.add(new PKey(l));
            keys.add(new EnterKey(l));
            addListeners(keys);
            //addListeners();

        }

        public void setNode(HexSpace node){
            this.root = node;
        }
        public HexSpace getNode(){
            return root;
        }
        public void addListeners(){
            for(KeyPressed kp: keySet){
                addKeyListener(kp);
            }
        }

        public void addListeners(List<KeyAdapter> keys){
            for(KeyAdapter ka: keys){
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
                for (int j = 0; j < board.getLength(i); j++) {
                    HexSpace curr = (HexSpace) board.getSpace(new Location(j, i));
                    Location loc = curr.getLocation();
                    AreaViewportController.drawHex(loc.getXLocation(), loc.getYLocation(), g2);
                }
            }
            // fill in hexes
            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < board.getLength(i); j++) {
                    // if (board[i][j] < 0)
                    // AreaViewportController.fillHex(i,j,COLOURONE,-board[i][j],g2);
                    // if (board[i][j] > 0) AreaViewportController.fillHex(i,j,COLOURTWO,
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

        class PKey extends KeyAdapter{
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

        class EnterKey extends KeyAdapter{
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
                    if(getNode().getNeighbor(0) != null)
                    {
                        HexSpace neighbor = (HexSpace)getNode().getNeighbor(0);
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


        class TwoKey extends KeyAdapter {

            public TwoKey() {
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '2') {
                    System.out.println(ke.getKeyChar());
                    if(getNode().getNeighbor(1) != null)
                    {
                        HexSpace neighbor = (HexSpace)getNode().getNeighbor(1);
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

        class ThreeKey extends KeyAdapter {
            public ThreeKey() {
            }

            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == '3') {
                    System.out.println(ke.getKeyChar());
                    if(getNode().getNeighbor(2) != null)
                    {
                        HexSpace neighbor = (HexSpace)getNode().getNeighbor(2);
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
            private Location l;

            public SevenKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                HexSpace curr = (HexSpace) board.getSpace(l);
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '7') {
                    //System.out.println(ke.getKeyChar());
                    if (x % 2 == 0)
                        p = new Point(x - 1, y - 1);
                    else
                        p = new Point(x - 1, y);
                    if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE)
                        return;
                    else {
                        curr.status = (int) ' ';
                        curr.color = Color.ORANGE;
                        x = p.x;
                        y = p.y;
                        System.out.println("LOC: " + x + " " + y + "");
                    }
                }
                l.setLocation(x, y);
                HexSpace hexSpace = (HexSpace) board.getSpace(l);
                hexSpace.status = (int) 'X';
                hexSpace.color = Color.GREEN;;
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
                    if(getNode().getNeighbor(4) != null)
                    {
                        HexSpace neighbor = (HexSpace)getNode().getNeighbor(4);
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
                    if(getNode().getNeighbor(5) != null)
                    {
                        HexSpace neighbor = (HexSpace)getNode().getNeighbor(5);
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

        // end of MyMouseListener class
    } // end of DrawingPanel class
}