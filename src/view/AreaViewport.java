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
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        // mouse variables here
        // Point mPt = new Point(0,0);

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
            //addListeners();

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
                for (int j = 0; j < BSIZE; j++) {
                    AreaViewportController.drawHex(i, j, g2);
                }
            }
            // fill in hexes
            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < BSIZE; j++) {
                    // if (board[i][j] < 0)
                    // AreaViewportController.fillHex(i,j,COLOURONE,-board[i][j],g2);
                    // if (board[i][j] > 0) AreaViewportController.fillHex(i,j,COLOURTWO,
                    // board[i][j],g2);
                    HexSpace curr = (HexSpace) board.getSpace(new Location(i, j));
                    AreaViewportController.fillHex(i, j, curr.status,
                            curr.color, g2);
                }
            }

            // g.setColor(Color.RED);
            // g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);
        }


        class OneKey extends KeyAdapter {
            private Location l;

            public OneKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                HexSpace curr = (HexSpace) board.getSpace(l);
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '1') {
                    //System.out.println("One:" + ke.getKeyChar());
                    if (x % 2 == 0)
                        p = new Point(x - 1, y);
                    else
                        p = new Point(x - 1, y + 1);
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
                hexSpace.color = Color.GREEN;
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
                HexSpace curr = (HexSpace) board.getSpace(l);
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '2') {
                    //System.out.println(ke.getKeyChar());
                    p = new Point(x, y + 1);
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
                hexSpace.color = Color.GREEN;
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
                HexSpace curr = (HexSpace) board.getSpace(l);
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '3') {
                    //System.out.println(ke.getKeyChar());
                    if (x % 2 == 0)
                        p = new Point(x + 1, y);
                    else
                        p = new Point(x + 1, y + 1);
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
                hexSpace.color = Color.GREEN;
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
            private Location l;

            public EightKey(Location l) {
                this.l = l;
            }

            public void keyTyped(KeyEvent ke) {
                int x = l.getXLocation();
                int y = l.getYLocation();
                HexSpace curr = (HexSpace) board.getSpace(l);
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '8') {
                    //System.out.println(ke.getKeyChar());
                    p = new Point(x, y - 1);
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
                hexSpace.color = Color.GREEN;
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
                HexSpace curr = (HexSpace) board.getSpace(l);
                Point p = new Point(x, y);
                if (ke.getKeyChar() == '9') {
                    //System.out.println(ke.getKeyChar());
                    if (x % 2 == 0)
                        p = new Point(x + 1, y - 1);
                    else
                        p = new Point(x + 1, y);
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
                hexSpace.color = Color.GREEN;
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