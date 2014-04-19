package controller;

import model.PalaceCard;
import model.SharedResources;
import model.customExceptions.NoPalaceTilesLeft;

public class SharedResourcesController {

    SharedResources resources;

    public SharedResourcesController()
    {
        resources = new SharedResources();
    }

	public PalaceCard drawCard() {
		return resources.drawCard();
	}

	public int getThreeBlocksLeft() {
		return resources.getNumThreeBlockTiles();
	}

	public void placeThreeBlock() {
        resources.placeThreeBlock();
	}

	public int getIrrigationTilesLeft() {
		return resources.getNumIrrigationTiles();
	}

	public void placeIrrigationTile() {
        resources.placeIrrigationTile();
	}

	public void discardCard(PalaceCard p) {
        resources.discardCard(p);
	}

	public void placePalace(int level) throws NoPalaceTilesLeft {
        resources.placePalaceTile(level);
	}

    public void returnPalaceCard(PalaceCard c)
    {
        resources.returnCard(c);
    }
}
