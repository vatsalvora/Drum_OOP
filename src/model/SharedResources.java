package model;

import java.util.*;

public class SharedResources {
	ArrayList<ThreeBlock> threes;
	ArrayList<Integer> palaceTiles;

	public SharedResources() {
		threes = new ArrayList<ThreeBlock>();
		palaceTiles = new ArrayList<Integer>();

		for (int i = 0; i < 56; i++)
			;
		// add 56 three tiles
		for (int i = 0; i < 16; i++)
			;
		// add 16 Irrigation Tiles
	}

	public SharedResources(int thr, int irr, int[] pt) {
		threes = new ArrayList<ThreeBlock>();
		palaceTiles = new ArrayList<Integer>();

		for (int i = 0; i < thr; i++)
			threes.add(new ThreeBlock());

		for (int i = 0; i < irr; i++)
			;
		// irrigations.add(new OneBlock(TileType.IRRIGATION));

		for (int i = 0; i < pt.length; i++)
			palaceTiles.add(pt[i]);
	}

	public int numThreeBlocks() {
		return threes.size();
	}

	public int numPalaceTiles(int level) {
		return palaceTiles.get(level);
	}
}
