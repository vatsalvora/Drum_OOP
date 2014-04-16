package model;

import java.util.ArrayList;
import java.util.List;

/**
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

    public ArrayList<PalaceCard> getCards() {
        return cards;
    }

    // Functions for performing or undoing specific Player functions
    public void incrementFamePoints(int i) {
        famePoints += i;
    }

    public void decrementFamePoints(int i) throws IndexOutOfBoundsException {
        if (famePoints - 1 < 0) {
            throw new IndexOutOfBoundsException("Cannot decrement lower than 0.");
        }
        famePoints -= i;
    }

    public void placeDeveloper() throws IndexOutOfBoundsException {
        if (developersLeft > 0) {
            developersLeft--;
        } else {
            throw new IndexOutOfBoundsException("No more developers left");
        }
    }

    public void useActionToken() throws IndexOutOfBoundsException {
        if (actionTokens > 0) {
            actionTokens--;
        } else {
            throw new IndexOutOfBoundsException("No more action tokens left");
        }
    }

    public void placeRiceBlock() throws IndexOutOfBoundsException {
        if (riceBlocks > 0) {
            riceBlocks--;
        } else {
            throw new IndexOutOfBoundsException("No more rice blocks left");
        }
    }

    public void placeVillageBlock() throws IndexOutOfBoundsException {
        if (villageBlocks > 0) {
            villageBlocks--;
        } else {
            throw new IndexOutOfBoundsException("No more village blocks left");
        }
    }

    public void placeTwoBlock() throws IndexOutOfBoundsException {
        if (twoBlocks > 0) {
            twoBlocks--;
        } else {
            throw new IndexOutOfBoundsException("No more two blocks left");
        }
    }

    public void removeDeveloper() {
        developersLeft++;
    }

    public void returnActionToken() {
        actionTokens++;
    }

    public void returnRiceBlock() {
        riceBlocks++;
    }

    public void returnVillageBlock() {
        villageBlocks++;
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

    public boolean hasCard(PalaceCard p) {
        boolean ret = false;
        for (PalaceCard c : cards) {
            if (p.sameCardAs(c)) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    // toString for output purposes
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Name: ").append(name).append("\n");
        ret.append("Color: ").append(color).append("\n");
        ret.append("Fame Points: ").append(famePoints).append("\n");
        ret.append("Action Tokens: ").append(actionTokens).append("\n");
        ret.append("Rice Tiles: ").append(riceBlocks).append("\n");
        ret.append("Village Tiles: ").append(villageBlocks).append("\n");
        ret.append("Two Blocks: ").append(twoBlocks).append("\n");
        ret.append("Palace Cards:\n");
        for (PalaceCard card : cards) {
            ret.append(card.toString()).append("\n");
        }
        return ret.toString();
    }
}