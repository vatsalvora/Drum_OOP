package test;


import controller.TurnController;
import model.PalaceFestival;
import model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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

        Player currPlayer = turnController.getCurrentPlayer();
        assertTrue(currPlayer.getName().equals("Joe"));

        turnController.previousTurn();

        currPlayer = turnController.getCurrentPlayer();
        assertTrue(currPlayer.getName().equals("Laqueesha"));
    }

    @Test
    public void testGetPlayers() throws Exception {
        Player[] players = turnController.getPlayers();
        List<Player> list = Arrays.asList(players);
        assertNotNull(list);

        List<String> namesList = new ArrayList<String>();
        for (Player player : list) {
            namesList.add(player.getName());
        }

        for (String name : names) {
            namesList.contains(name);
        }
    }

    @Test
    public void testGetCurrentPlayer() throws Exception {
        assertEquals("Joe", turnController.getCurrentPlayer().getName());
    }

    @Test
    public void testGetPlayerName() throws Exception {
        assertEquals("Joe", turnController.getPlayerName());
    }

    @Test
    public void testGetPlayerColor() throws Exception {
        assertEquals("red", turnController.getPlayerColor());
    }

    @Test
    public void testGetCurrentCards() throws Exception {
        assertNotNull(turnController.getCurrentCards());
        assertEquals(0, turnController.getCurrentCards().size());
    }

    @Test
    public void testIncrementFamePoints() throws Exception {
        assertEquals(0, turnController.getCurrentPlayer().getFamePoints());

        turnController.incrementFamePoints(5);
        assertEquals(5, turnController.getCurrentPlayer().getFamePoints());

        turnController.incrementFamePoints(100);
        assertEquals(105, turnController.getCurrentPlayer().getFamePoints());
    }

    @Test
    public void testDecrementFamePoints() throws Exception {
        assertEquals(0, turnController.getCurrentPlayer().getFamePoints());

//        turnController.decrementFamePoints(5);
//        assertEquals(-5, turnController.getCurrentPlayer().getFamePoints());
    }

    @Test
    public void testPlaceDeveloper() throws Exception {
        Player player = turnController.getCurrentPlayer();
        assertEquals(12, player.getDevelopersLeft());

        for (int i = 0; i < 100; i++) {
            turnController.placeDeveloper(1);
        }
        assertEquals(0, player.getDevelopersLeft());
    }

    @Test
    public void testRemoveDeveloper() throws Exception {
        Player player = turnController.getCurrentPlayer();
        assertEquals(12, player.getDevelopersLeft());

        turnController.placeDeveloper(1);
        assertEquals(11, player.getDevelopersLeft());

        turnController.removeDeveloper();
        assertEquals(12, player.getDevelopersLeft());
    }

    @Test
    public void testUseActionToken() throws Exception {
        assertFalse(turnController.tokenUsed());
        turnController.useActionToken();
        assertTrue(turnController.tokenUsed());
    }

    @Test
    public void testReturnActionToken() throws Exception {
        assertFalse(turnController.tokenUsed());

        turnController.useActionToken();
        assertTrue(turnController.tokenUsed());

        turnController.returnActionToken();
        assertFalse(turnController.tokenUsed());
    }

    @Test
    public void testPlaceRiceBlock() throws Exception {
        Player player = turnController.getCurrentPlayer();
        assertEquals(3, player.getRiceBlocksLeft());

        turnController.placeRiceBlock();
        assertEquals(2, player.getRiceBlocksLeft());
    }

    @Test
    public void testReturnRiceBlock() throws Exception {
        Player player = turnController.getCurrentPlayer();
        assertEquals(3, player.getRiceBlocksLeft());

        turnController.placeRiceBlock();
        assertEquals(2, player.getRiceBlocksLeft());

        turnController.returnRiceBlock();
        assertEquals(3, player.getRiceBlocksLeft());
    }

    @Test
    public void testPlaceVillageBlock() throws Exception {
        Player player = turnController.getCurrentPlayer();
        assertEquals(2, player.getVillageBlocksLeft());

        turnController.placeVillageBlock();
        assertEquals(1, player.getVillageBlocksLeft());
    }

    @Test
    public void testReturnVillageBlock() throws Exception {
        Player player = turnController.getCurrentPlayer();
        assertEquals(3, player.getRiceBlocksLeft());

        turnController.placeRiceBlock();
        assertEquals(2, player.getRiceBlocksLeft());

        turnController.returnRiceBlock();
        assertEquals(3, player.getRiceBlocksLeft());
    }

    @Test
    public void testPlaceTwoBlock() throws Exception {
        Player player = turnController.getCurrentPlayer();
        assertEquals(5, player.getTwoBlocksLeft());

        turnController.placeTwoBlock();
        assertEquals(4, player.getTwoBlocksLeft());
    }

    @Test
    public void testReturnTwoBlock() throws Exception {
        Player player = turnController.getCurrentPlayer();
        assertEquals(5, player.getTwoBlocksLeft());

        turnController.placeTwoBlock();
        assertEquals(4, player.getTwoBlocksLeft());

        turnController.returnTwoBlock();
        assertEquals(5, player.getTwoBlocksLeft());
    }

    @Test
    public void testDrawFestivalCard() throws Exception {

    }


    @Test
    public void testUndoAction() throws Exception {
        assertEquals(6, turnController.APLeft());
        turnController.placeOtherBlock();
        assertEquals(5, turnController.APLeft());
//        turnController.undoAction(10);
        //      assertEquals(15, turnController.APLeft());
    }

    @Test
    public void testGetFestival() throws Exception {
        PalaceFestival palaceFestival = turnController.getFestival();
        assertNotNull(palaceFestival);
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
    public void testFreezeFestivalPlayer() throws Exception {

    }

    @Test
    public void testGetVictors() throws Exception {

    }

    @Test
    public void testGetCurrentFestivalPlayer() throws Exception {

    }

    //    @Test
//    public void testPlaceOtherBlock() throws Exception {
//        Player player = turnController.getCurrentPlayer();
//        assertEquals(5, player.());
//
//        turnController.placeOtherBlock();
//        assertEquals(4, player.get);
//    }
//
//    @Test
//    public void testReturnOtherBlock() throws Exception {
//
//    }
    @Test
    public void testPerformAction() throws Exception {

    }
}
