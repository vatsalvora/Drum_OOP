package controller;

import model.Deck;
import view.SharedResourcesView;
import model.PalaceCard;
import model.SharedResources;
import model.customExceptions.NoIrrigationLeftException;
import model.customExceptions.NoPalaceTilesLeft;
import model.customExceptions.NoThreeBlockLeftException;


public class SharedResourcesController {

    SharedResources resources;
    SharedResourcesView srv;

    public SharedResourcesController() {
        resources = new SharedResources();
        srv = new SharedResourcesView();
        srv.updateFields(resources);

    }

    public PalaceCard drawCard() {
    	srv.updateFields(resources);
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
        srv.updateFields(resources);
    }

    public void returnThreeBlock() {
        resources.returnThreeBlock();
    }

    public int getIrrigationTilesLeft() {
        return resources.getNumIrrigationTiles();
    }

    public void placeIrrigationTile() throws NoIrrigationLeftException {

        resources.placeIrrigationTile();
        srv.updateFields(resources);
    }

    public void returnIrrigationTile() {
        resources.returnIrrigationTile();
        srv.updateFields(resources);
    }

    public void discardCard(PalaceCard p) {
        resources.discardCard(p);
        srv.updateFields(resources);
    }

    public void placePalace(int level) throws NoPalaceTilesLeft {
        resources.placePalaceTile(level);
        srv.updateFields(resources);
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
}
