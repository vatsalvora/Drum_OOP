package view;

import model.Board;
import model.GameFacade;
import model.Location;
import model.Space;
import model.state.*;
import view.keypressed.*;
import view.keypressed.KeyPressed1;
import view.keypressed.KeyPressed2;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**********************************
 * This is the main class of a Java program to play a game based on hexagonal
 * tiles. The mechanism of handling hexes is in the file hexmech.java.
 * 
 * Written by: M.H. Date: December 2012
 ***********************************/

public class hexgame {
	// constants and global variables
	final static Color COLOURBACK = Color.WHITE;

    final static Color COLOURCELL = Color.ORANGE;

    final static Color COLOURGRID = Color.BLACK;
    final static Color COLOURONE = new Color(255, 255, 255, 200);
    final static Color COLOURONETXT = Color.BLUE;
    final static Color COLOURTWO = new Color(0, 0, 0, 200);
    final static Color COLOURTWOTXT = new Color(255, 100, 255);
    final static int EMPTY = 0;
    final static int BSIZE = 12; // board size.
    final static int HEXSIZE = 60; // hex size in pixels
    final static int BORDERS = 15;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3; // screen
    private Board board = new Board();
    private List<KeyPressed> keyset;
    // dimension).
    // (vertical
    // size
    public hexgame(GameFacade b, List<KeyPressed> keyset) {
        this.keyset = keyset;
        initGame();
        createAndShowGUI();
    }

	void initGame() {

		hexmech.setXYasVertex(false); // RECOMMENDED: leave this as FALSE.

		hexmech.setHeight(HEXSIZE); // Either setHeight or setSize must be run
									// to initialize the hex
		hexmech.setBorders(BORDERS);

		for (int i = 0; i < BSIZE; i++) {
			for (int j = 0; j < BSIZE; j++) {
				board.getSpace(new Location(i, j)).status = EMPTY;
			}
		}

		// set up board here
		board.getSpace(new Location(3, 3)).status = (int) 'A';
		board.getSpace(new Location(4, 3)).status = (int) 'Q';
		board.getSpace(new Location(4, 4)).status = -(int) 'B';
	}

	private void createAndShowGUI() {
		DrawingPanel panel = new DrawingPanel();

		// JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Hex Testing 4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = frame.getContentPane();
		frame.setFocusable(false);
		panel.setFocusable(true);
		content.add(panel);
		// this.add(panel); -- cannot be done in a static context
		// for hexes in the FLAT orientation, the height of a 10x10 grid is
		// 1.1764 * the width. (from h / (s+t))
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

			MyMouseListener ml = new MyMouseListener();
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

			addMouseListener(ml);


		}

        public void addListeners(){
            for(KeyPressed kp: keyset){
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
					hexmech.drawHex(i, j, g2);
				}
			}
			// fill in hexes
			for (int i = 0; i < BSIZE; i++) {
				for (int j = 0; j < BSIZE; j++) {
					// if (board[i][j] < 0)
					// hexmech.fillHex(i,j,COLOURONE,-board[i][j],g2);
					// if (board[i][j] > 0) hexmech.fillHex(i,j,COLOURTWO,
					// board[i][j],g2);
					hexmech.fillHex(i, j, board.getSpace(new Location(i, j)).status,
							board.getSpace(new Location(i, j)).color, g2);
				}
			}

			// g.setColor(Color.RED);
			// g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);
		}

		class MyMouseListener extends MouseAdapter { // inner class inside
														// DrawingPanel
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				// mPt.x = x;
				// mPt.y = y;

				Point p = new Point(hexmech.pxtoHex(e.getX(), e.getY()));
				if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE)
					return;

				// DEBUG: colour in the hex which is supposedly the one clicked
				// on
				// clear the whole screen first.
				/*
				 * for (int i=0;i<BSIZE;i++) { for (int j=0;j<BSIZE;j++) {
				 * board[i][j]=EMPTY; } }
				 */

				// What do you want to do when a hexagon is clicked?
                //System.out.println("LOC: " + p.x + " " + p.y + "");
                Space s = board.getSpace(new Location(p.x,p.y));
                System.out.println("Current: "+ s.getLocation());
                s.status = (int) 'X';
                s.color = Color.GREEN;
                Space[] neighbors = s.getNeighbors();
                for(Space sp: neighbors){
                    if(sp != null){
                        System.out.println(sp.getLocation());
                    }
                }
				repaint();
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
				board.getSpace(new Location(p.x, p.y)).status = (int) 'X';
				board.getSpace(new Location(p.x, p.y)).color = Color.GREEN;
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
                board.getSpace(new Location(p.x, p.y)).status = (int) 'X';
                board.getSpace(new Location(p.x, p.y)).color = Color.GREEN;
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
				board.getSpace(new Location(p.x, p.y)).status = (int) 'X';
				board.getSpace(new Location(p.x, p.y)).color = Color.GREEN;
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
				board.getSpace(new Location(p.x, p.y)).status = (int) 'X';
				board.getSpace(new Location(p.x, p.y)).color = Color.GREEN;
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
				board.getSpace(new Location(p.x, p.y)).status = (int) 'X';
				board.getSpace(new Location(p.x, p.y)).color = Color.GREEN;
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
				board.getSpace(new Location(p.x, p.y)).status = (int) 'X';
				board.getSpace(new Location(p.x, p.y)).color = Color.GREEN;
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