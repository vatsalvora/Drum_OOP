package model;

import java.util.HashMap;
import java.util.Map;

public class SharedResources {
    private Deck deck;
    private int numIrrigationTiles;
    private int numThreeBlockTiles;
    private Map<PalaceLevel, Integer> numTilesInPalaceLevel;

    public SharedResources() {
        this.deck = new Deck();
        this.numIrrigationTiles = 16;
        this.numThreeBlockTiles = 56;
        this.numTilesInPalaceLevel = new HashMap<PalaceLevel, Integer>();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getNumIrrigationTiles() {
        return numIrrigationTiles;
    }

    public void setNumIrrigationTiles(int numIrrigationTiles) {
        this.numIrrigationTiles = numIrrigationTiles;
    }

    public int getNumThreeBlockTiles() {
        return numThreeBlockTiles;
    }

    public void setNumThreeBlockTiles(int numThreeBlockTiles) {
        this.numThreeBlockTiles = numThreeBlockTiles;
    }

    public int getNumTilesInPalaceLevel(PalaceLevel level) {
        return numTilesInPalaceLevel.get(level);
    }

    public void addTileToPalaceLevel(PalaceLevel level) {
        int numTile = this.numTilesInPalaceLevel.get(level);
        this.numTilesInPalaceLevel.put(level, ++numTile);
    }
}
