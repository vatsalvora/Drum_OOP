package view;

import model.*;
import view.keypressed.KeyPressed;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class AreaViewport {
    public Color COLOR_BACK = Color.WHITE;

    public  Color COLOR_CELL = new Color(239, 221, 111);
    public Color GREEN = new Color(34,139,34);
    public Color PURPLE = new Color(203, 0, 245);
    private Color cornflower_blue = new Color(100, 149, 237);
    public  Color COLOR_GRID = Color.BLACK;

    public  String EMPTY = "";
    public  int BOARD_SIZE = 12; // board size.
    public  int HEX_SIZE = 46; // hex size in pixels
    public  int BORDERS = 15;
    public  int SCREEN_Width = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3; // screen
    public  int SCREEN_LEN = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3;
    public  boolean XYVertex = true;
    private int palaceLvl;

    private  int s = 0; // length of one side
    private  int t = 0; // short side of 30o triangle outside of each hex
    private  int r = 0; // radius of inscribed circle (centre to middle of
    // each side). r= h/2
    private  int h = 0; // height. Distance between centres of two
    // adjacent hexes. Distance between two opposite
    // sides in a hex.
    public int scrolldown;
    public Color devColor;
    private  Color movement;
    private DrawingPanel panel;

    public AreaViewport(Board board) {
        BOARD_SIZE = board.getWidth();
        scrolldown = 0;
        palaceLvl = 0;
        devColor = cornflower_blue;
        int maxLen = board.getMaxLen();
        movement = new Color(100,149,237);
        SCREEN_Width = HEX_SIZE * (BOARD_SIZE + 1) + BORDERS * 3;
        SCREEN_LEN = HEX_SIZE * (maxLen + 1) + BORDERS * 3;

        initGame(board);
        createAndShowGUI(board);
    }

    public void setDevColor(Color color){
        devColor = color;
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



    public  void fillHex(int i, int j, String n,  Graphics2D g2, Color... color) {
        char c;
        int x = i * (s + t);
        int y = j * h + (i % 2) * h / 2;
        Polygon poly = hex(x, y);
        g2.setColor(color[0]);
        g2.fillPolygon(poly);
        g2.setColor(color[2]);
        g2.drawPolygon(poly);


        g2.setColor(color[1]);
        g2.fillRect(x + 10 + BORDERS, y + 10 + BORDERS, 10, 10);
        if(color.length == 4) g2.setColor(Color.BLACK);
        g2.drawRect(x + 10 + BORDERS, y + 10 + BORDERS, 10, 10);
        g2.setColor(Color.BLACK);
        g2.drawString("" + n, x + r + BORDERS, y + r + BORDERS + 4);

    }
    public void initGame(Board board) {

        setXYasVertex(false); // RECOMMENDED: leave this as FALSE.

        setHeight(HEX_SIZE); // Either setHeight or setSize must be run
        setBorders(BORDERS);


        // set up board here
        Tile t1 = new IrrigationTile(0);
        Tile t2 = new IrrigationTile(0);
        Tile t3 = new IrrigationTile(0);
        try {
            ((HexSpace) board.getSpace(new Location(3, 3))).place(t1);
            ((HexSpace) board.getSpace(new Location(5, 8))).place(t2);
            ((HexSpace) board.getSpace(new Location(3, 15))).place(t3);
        }
        catch(Exception e)
        {
            //should never happen
        }
    }

    private void createAndShowGUI(Board board) {
        panel = new DrawingPanel(board);
        JFrame frame = new JFrame("Java: The Board Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        frame.setFocusable(false);
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);
        content.add(panel);

        frame.setSize((int) (SCREEN_Width / 1.23), (int) (SCREEN_LEN * 1.05));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLocation(400,0);
        frame.setVisible(true);
    }

    public void setMovement(Color color){
        movement = color;
    }
    public void render(Board board){
        panel.setBoard(board);
        panel.repaint();
    }

    public void render(Board board, List<Space> Path) {
        panel.setPath(Path);
        panel.repaint();
    }

    public void addKeyListeners(List<KeyPressed> keySet){
        panel.addListeners(keySet);
    }
    public void setPalaceLvl(int lvl){
        palaceLvl = lvl;
    }
    public int getPalaceLvl(){return palaceLvl;}
    class DrawingPanel extends JPanel {

        private Board board;
        private  final long serialVersionUID = 1L;
        private List<Space> path;

        public DrawingPanel(Board board) {
            this.board = board;
            this.path = new ArrayList<Space>(0);
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
                int len = board.getLength(i);
                //if(len>5 && 5+scrolldown<len) len = 5+scrolldown;
                //0+scrolldown
                for (int j = 0; j <len; j++) {

                    HexSpace curr = (HexSpace) board.getSpace(new Location(j, i));
                    Location loc = curr.getLocation();
                    String status = "";

                    if(curr.getHeight()>0){
                        try{
                            status = ((PalaceTile)curr.getTopTile()).getLvl()+"";
                        }
                        catch(Exception e){
                            status = curr.getHeight()+"";
                        }
                    }
                    int[] dir = {0,1,2,5,4,3};

                    Color[] tileColor = curr.getColor();
                    Color[] color = new Color[]{tileColor[0],tileColor[1],tileColor[2]};
                    if(curr.getHeight() == 0 && curr.onBorder() && j>5){
                        color[0] = PURPLE;
                        color[1] = PURPLE;
                    }

                    int[] rotations = board.getRotations();
                    for(int q=0; q<rotations.length; q++){
                        if(curr.equals(board.getCurrentSpace().getNeighbor(dir[rotations[q]]))){
                            color[0] = movement;
                            color[1] = movement;
                        }
                    }

                    if(curr.equals(board.getCurrentSpace()))
                    {
                        color[0] = movement;
                        color[1] = devColor;
                        color[2] = Color.BLACK;
                        if(palaceLvl>0) status = palaceLvl+"";
                    }

                        fillHex(loc.getXLocation(), loc.getYLocation(), status,
                                g2, color[0], color[1], color[2]);
                }
            }

            // g.setColor(Color.RED);
            // g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);

            for(Space s: path){
                HexSpace h = (HexSpace)s;
                Location loc = h.getLocation();
                Color[] color = h.getColor();
                if(h.onBorder() && h.getLocation().getXLocation()>3){
                    color[0] = GREEN;
                    color[1] = GREEN;
                }
                if(h.equals(board.getCurrentSpace()))
                {
                    fillHex(loc.getXLocation(), loc.getYLocation(), "",
                            g2,movement,devColor,Color.RED);
                }
                else {
                    fillHex(loc.getXLocation(), loc.getYLocation(), "",
                            g2,color[0],color[1],Color.RED);
                }
            }
            path = new ArrayList<Space>(0);



        }

        public void setPath(List<Space> path) {
            this.path = path;
        }

        public List<Space> getPath() {
            return path;
        }
    } // end of DrawingPanel class


}