package model;

import java.util.ArrayList;

public class SharedResources {
    ArrayList<ThreeBlock> threes;
    ArrayList<Integer> palaceTiles;
    ArrayList<IrrigationTile> irrigationTiles;

    public SharedResources() {
        threes = new ArrayList<ThreeBlock>();
        palaceTiles = new ArrayList<Integer>();
        irrigationTiles = new ArrayList<IrrigationTile>();

        // add 56 three tiles
        for (int i = 0; i < 56; i++) {
            //TODO Please make sure this is right and updated after implmenting three block tile
            threes.add(new ThreeBlock());
        }

        // add 16 Irrigation Tiles
        for (int i = 0; i < 16; i++) {
            //TODO Need to add num neighbors to irrigation tiles
//        irrigationTiles.add(new IrrigationTile());
        }


    }

    public SharedResources(int thr, int irr, int[] pt) {
        threes = new ArrayList<ThreeBlock>();
        palaceTiles = new ArrayList<Integer>();

        for (int i = 0; i < thr; i++)
            threes.add(new ThreeBlock());

        for (int i = 0; i < irr; i++) {
        }

        // irrigations.add(new OneBlock(TileType.IRRIGATION));

        for (int aPt : pt) {
            palaceTiles.add(aPt);
        }
    }

    public int numThreeBlocks() {
        return threes.size();
    }

    public int numPalaceTiles(int level) {
        return palaceTiles.get(level);
    }
}
