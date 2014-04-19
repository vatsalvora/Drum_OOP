package model;


import model.customExceptions.NoPalaceTilesLeft;

import model.customExceptions.NoIrrigationLeftException;
import model.customExceptions.NoPalaceTilesLeft;
import model.customExceptions.NoThreeBlockLeftException;


import java.util.ArrayList;

public class SharedResources {
    private Deck deck;
    private int numIrrigationTiles;
    private int numThreeBlockTiles;
    private int levelTwoPalace;
    private int levelFourPalace;
    private int levelSixPalace;
    private int levelEightPalace;
    private int levelTenPalace;

    public SharedResources() {
        this.deck = new Deck();
        this.numIrrigationTiles = 16;
        this.numThreeBlockTiles = 56;
        levelTwoPalace = 6;
        levelFourPalace = 7;
        levelSixPalace = 8;
        levelEightPalace = 9;
        levelTenPalace = 10;
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

    public int getNumTwoPalaces() {
        return levelTwoPalace;
    }

    public int getNumFourPalaces()
    {
        return levelFourPalace;
    }

    public int getNumSixPalaces()
    {
        return levelSixPalace;
    }

    public int getNumEightPalaces()
    {
        return levelEightPalace;
    }

    public int getNumTenPalaces()
    {
        return levelTenPalace;
    }

    public void placeIrrigationTile() throws NoIrrigationLeftException

    {
        if(numIrrigationTiles > 0)
        {
            numIrrigationTiles--;
        }
        else
        {

            //put-in: no irrigation tiles left
        }
    }



    public void placeThreeBlock() throws NoThreeBlockLeftException

    {
        if(numThreeBlockTiles > 0)
        {
            numThreeBlockTiles--;
        }
        else
        {

            throw new NoThreeBlockLeftException();

        }
    }

    public void placePalaceTile(int i) throws NoPalaceTilesLeft
    {
        switch(i)
        {
            case 2:
                if(levelTwoPalace > 0)
                {
                    levelTwoPalace--;
                }
                else
                {
                    throw new NoPalaceTilesLeft("2");
                }
                break;
            case 4:
                if(levelFourPalace > 0)
                {
                    levelFourPalace--;
                }
                else
                {
                    throw new NoPalaceTilesLeft("4");
                }
                break;
            case 6:
                if(levelSixPalace > 0)
                {
                    levelSixPalace--;
                }
                else
                {
                    throw new NoPalaceTilesLeft("6");
                }
                break;
            case 8:
                if(levelEightPalace > 0)
                {
                    levelEightPalace--;
                }
                else
                {
                    throw new NoPalaceTilesLeft("8");
                }
                break;
            case 10:
                if(levelTenPalace > 0)
                {
                    levelTenPalace--;
                }
                else
                {
                    throw new NoPalaceTilesLeft("10");
                }
                break;
            default:
                throw new NoPalaceTilesLeft("" + i + "");
        }
    }

    public PalaceCard drawCard()
    {
        return deck.drawCard();
    }

    public void discardCard(PalaceCard c)
    {
        deck.discardCard(c);
    }

    public void returnCard(PalaceCard c)
    {
        deck.returnCard(c);
    }
}
