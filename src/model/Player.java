package model;

import model.customExceptions.*;

import java.util.ArrayList;
import java.util.List;

/*
 The Player class is a state object containing the inventory and general information of a player.
 */

public class Player {
    private String name;
    private String color;
    private int famePoints;
    private int developersLeft;
    private int actionTokens;
    private int riceBlocks;
    private int villageBlocks;
    private int twoBlocks;
    private ArrayList<PalaceCard> cards;

    public Player() {
        name = "Dave";
        color = "blue";
        famePoints = 0;
        developersLeft = 12;
        actionTokens = 3;
        riceBlocks = 3;
        villageBlocks = 2;
        twoBlocks = 5;
        cards = new ArrayList<PalaceCard>();
    }

    public Player(String n, String c) {
        name = n;
        color = c;
        famePoints = 0;
        developersLeft = 12;
        actionTokens = 3;
        riceBlocks = 3;
        villageBlocks = 2;
        twoBlocks = 5;
        cards = new ArrayList<PalaceCard>();
    }

    // Setters
    public void setName(String n) {
        name = n;
    }

    public void setColor(String c) {
        color = c;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFamePoints() {
        return famePoints;
    }

    public int getDevelopersLeft() {
        return developersLeft;
    }

    public int getActionTokens() {
        return actionTokens;
    }

    public int getRiceBlocksLeft() {
        return riceBlocks;
    }

    public int getVillageBlocksLeft() {
        return villageBlocks;
    }

    public int getTwoBlocksLeft() {
        return twoBlocks;
    }

    public List<PalaceCard> getCards() {
        return cards;
    }

    // Functions for performing or undoing specific Player functions
    public void incrementFamePoints(int i) {
        famePoints += i;
    }

    public void decrementFamePoints(int i) throws Exception {
        if (famePoints - 1 < 0) {
            throw new Exception("Cannot decrement lower than 0.");
        }
        famePoints -= i;
    }

    public void placeDeveloper() throws NoDevsLeftException {
        if (developersLeft > 0) {
            developersLeft--;
        } else {
            throw new NoDevsLeftException();
        }
    }

    public void removeDeveloper() {
        developersLeft++;
    }

    public void useActionToken() throws NoActionTokensException {
        if (actionTokens > 0) {
            actionTokens--;
        } else {
            throw new NoActionTokensException();
        }
    }

    public void returnActionToken() {
        actionTokens++;
    }

    public void placeRiceBlock() throws NoRiceBlocksException {
        if (riceBlocks > 0) {
            riceBlocks--;
        } else {
            throw new NoRiceBlocksException();
        }
    }

    public void returnRiceBlock() {
        riceBlocks++;
    }

    public void placeVillageBlock() throws NoVillageTilesException {
        if (villageBlocks > 0) {
            villageBlocks--;
        } else {
            throw new NoVillageTilesException();
        }
    }

    public void returnVillageBlock() {
        villageBlocks++;
    }

    public void placeTwoBlock() throws NoTwoBlocksException {
        if (twoBlocks > 0) {
            twoBlocks--;
        } else {
            throw new NoTwoBlocksException();
        }
    }

    public void returnTwoBlock() {
        twoBlocks++;
    }

    // Palace card and festival methods
    public void addCard(PalaceCard c) {
        cards.add(c);
    }

    public void addManyCards(List<PalaceCard> c) {
        cards.addAll(c);
    }

    public void removeCard(PalaceCard c) {
        boolean removed = false;
        for (int i = 0; i < cards.size() && !removed; i++) {
            if (c.sameCardAs(cards.get(i))) {
                cards.remove(i);
                removed = true;
            }
        }
    }

    public boolean hasPlayableCard(PalaceCard c) {
        boolean ret = false;
        for (PalaceCard card : cards) {
            if (card.compare(c) > 0) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public boolean hasCard(PalaceCard p) throws CardNotInHandException {
        for (PalaceCard c : cards) {
            if (p.sameCardAs(c)) {
                return true;
            }
        }
        throw new CardNotInHandException();
    }

    // toString for output purposes
    public String toString() {
        String ret;
        ret = "Name: " + name + "\n";
        ret += "Color: " + color + "\n";
        ret += "Fame Points: " + famePoints + "\n";
        ret += "Action Tokens: " + actionTokens + "\n";
        ret += "Rice Tiles: " + riceBlocks + "\n";
        ret += "Village Tiles: " + villageBlocks + "\n";
        ret += "Two Blocks: " + twoBlocks + "\n";
        ret += "Palace Cards:\n";
        for (PalaceCard card : cards) {
            ret += card.toString() + "\n";
        }
        return ret;
    }
}