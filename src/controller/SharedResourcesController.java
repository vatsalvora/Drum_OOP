package controller;

import model.Deck;
import model.PalaceCard;
import model.SharedResources;
import model.customExceptions.NoIrrigationLeftException;
import model.customExceptions.NoPalaceTilesLeft;
import model.customExceptions.NoThreeBlockLeftException;
import view.SharedResourcesView;


public class SharedResourcesController {

    SharedResources resources;
    SharedResourcesView srv;

    public SharedResourcesController(TurnController tc) {
        resources = new SharedResources();
        srv = new SharedResourcesView(tc, resources);
    }

    public PalaceCard drawCard() {
        return resources.drawCard();
    }

    public void returnCard(PalaceCard c) {
        resources.returnCard(c);
    }

    public int getThreeBlocksLeft() {
        return resources.getNumThreeBlockTiles();
    }

    public void placeThreeBlock() throws NoThreeBlockLeftException {
        resources.placeThreeBlock();
    }

    public void returnThreeBlock() {
        resources.returnThreeBlock();
    }

    public int getIrrigationTilesLeft() {
        return resources.getNumIrrigationTiles();
    }

    public void placeIrrigationTile() throws NoIrrigationLeftException {

        resources.placeIrrigationTile();
    }

    public void returnIrrigationTile() {
        resources.returnIrrigationTile();
    }

    public void discardCard(PalaceCard p) {
        resources.discardCard(p);
    }

    public void placePalace(int level) throws NoPalaceTilesLeft {
        resources.placePalaceTile(level);
    }

    public void returnPalace(int i) {
        resources.returnPalace(i);
    }

    public void returnPalaceCard(PalaceCard c) {
        resources.returnCard(c);
    }

    public Deck getDeck() {
        return resources.getDeck();
    }

    public void render()
    {
        srv.updateFields();
        srv.updatePlayers();
    }
}
