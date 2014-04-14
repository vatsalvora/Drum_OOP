package test;


import model.Player;
import model.TurnController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by devan on 4/13/14.
 */
public class TurnControllerTest {
    String[] names = {"Joe", "Chantelle", "Destiny", "Laqueesha"};
    TurnController turnController;

    @Before
    public void setUp() {
        turnController = new TurnController(names);

    }

    @Test
    public void testPlayedBlock() throws Exception {
        boolean canPlayOtherBlock = turnController.playedBlock();
        assertFalse(canPlayOtherBlock);

        turnController.placeOtherBlock();
        canPlayOtherBlock = turnController.playedBlock();
        assertTrue(canPlayOtherBlock);

        for (int i = 0; i < 10; i++) {
            turnController.placeOtherBlock();
        }
        canPlayOtherBlock = turnController.playedBlock();
        assertTrue(canPlayOtherBlock);
    }

    @Test
    public void testNextTurn() throws Exception {
        for (int i = 0; i < 10; i++) {
            turnController.placeOtherBlock();
        }
        assertTrue(turnController.APLeft() >= 0);
        Player currPlayer = turnController.getCurrentPlayer();
        assertTrue(currPlayer.getName().equals("Joe"));

        turnController.nextTurn();
        assertTrue(turnController.APLeft() == 6);
        currPlayer = turnController.getCurrentPlayer();
        assertTrue(currPlayer.getName().equals("Chantelle"));
        assertFalse(turnController.tokenUsed());

        turnController.nextTurn();
        assertTrue(turnController.APLeft() == 6);
        currPlayer = turnController.getCurrentPlayer();
        assertTrue(currPlayer.getName().equals("Destiny"));
        assertFalse(turnController.tokenUsed());

        turnController.nextTurn();
        assertTrue(turnController.APLeft() == 6);
        currPlayer = turnController.getCurrentPlayer();
        assertTrue(currPlayer.getName().equals("Laqueesha"));
        assertFalse(turnController.tokenUsed());

        turnController.nextTurn();
        assertTrue(turnController.APLeft() == 6);
        currPlayer = turnController.getCurrentPlayer();
        assertTrue(currPlayer.getName().equals("Joe"));
        assertFalse(turnController.tokenUsed());
    }

    @Test
    public void testPreviousTurn() throws Exception {

    }

    @Test
    public void testGetPlayers() throws Exception {

    }

    @Test
    public void testGetCurrentPlayer() throws Exception {

    }

    @Test
    public void testGetPlayerName() throws Exception {

    }

    @Test
    public void testGetPlayerColor() throws Exception {

    }

    @Test
    public void testGetCurrentCards() throws Exception {

    }

    @Test
    public void testIncrementFamePoints() throws Exception {

    }

    @Test
    public void testDecrementFamePoints() throws Exception {

    }

    @Test
    public void testPlaceDeveloper() throws Exception {

    }

    @Test
    public void testRemoveDeveloper() throws Exception {

    }

    @Test
    public void testUseActionToken() throws Exception {

    }

    @Test
    public void testReturnActionToken() throws Exception {

    }

    @Test
    public void testPlaceRiceBlock() throws Exception {

    }

    @Test
    public void testReturnRiceBlock() throws Exception {

    }

    @Test
    public void testPlaceVillageBlock() throws Exception {

    }

    @Test
    public void testReturnVillageBlock() throws Exception {

    }

    @Test
    public void testPlaceTwoBlock() throws Exception {

    }

    @Test
    public void testReturnTwoBlock() throws Exception {

    }

    @Test
    public void testAddCard() throws Exception {

    }

    @Test
    public void testDrawCard() throws Exception {

    }

    @Test
    public void testDrawFestivalCard() throws Exception {

    }

    @Test
    public void testPlaceOtherBlock() throws Exception {

    }

    @Test
    public void testReturnOtherBlock() throws Exception {

    }

    @Test
    public void testPerformAction() throws Exception {

    }

    @Test
    public void testUndoAction() throws Exception {

    }

    @Test
    public void testGetFestival() throws Exception {

    }

    @Test
    public void testStartFestival() throws Exception {

    }

    @Test
    public void testChangeFestivalPlayer() throws Exception {

    }

    @Test
    public void testPlayCard() throws Exception {

    }

    @Test
    public void testFreeseFestivalPlayer() throws Exception {

    }

    @Test
    public void testGetVictors() throws Exception {

    }

    @Test
    public void testGetCurrentFestivalPlayer() throws Exception {

    }
}
