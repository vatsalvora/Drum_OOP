package model;

import java.util.ArrayList;
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

    public void setDeck(ArrayList<PalaceCard> list) {
        deck.reset(list, new ArrayList<PalaceCard>());
    }

    public int getNumIrrigationTiles() {
        return numIrrigationTiles;
    }

    public int getNumThreeBlockTiles() {
        return numThreeBlockTiles;
    }

    public int getNumTilesInPalaceLevel(PalaceLevel level) {
        return numTilesInPalaceLevel.get(level);
    }

    public void addTileToPalaceLevel(PalaceLevel level) {
        int numTile = this.numTilesInPalaceLevel.get(level);
        this.numTilesInPalaceLevel.put(level, ++numTile);
    }
}
