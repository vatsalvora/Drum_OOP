package test;

import model.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by devan on 4/17/14.
 */
public class BoardTest {
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

//    @Test
//    public void testInitBoard() throws Exception {
//        board.initBoard();
//        assertNotNull(board.getBoard());
//    }

    @Test
    public void testSetNeighbors() throws Exception {

    }

//    @Test
//    public void testGetSpace() throws Exception {
//        Location l = new Location(3,4);
//
//        Space space = board.getSpace(l);
//        Space space1 = board.getSpace(new Location(3,5));
//        assertNotEquals(space, space1);
//    }
}
