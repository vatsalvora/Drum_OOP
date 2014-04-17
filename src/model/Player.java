package model;

import java.util.*;

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

    public ArrayList<PalaceCard> getCards() {
        return cards;
    }

    // Functions for performing or undoing specific Player functions
    public void incrementFamePoints(int i) {
        famePoints += i;
    }

    public void decrementFamePoints(int i) throws Exception {
        if(famePoints - 1 < 0){
            throw new Exception("Cannot decrement lower than 0.");
        }
        famePoints -= i;
    }

    public void placeDeveloper() {
        if (developersLeft > 0) {
            developersLeft--;
        } else {
            // put-in: throw not enough developers exception
        }
    }

    public void removeDeveloper() {
        developersLeft++;
    }

    public void useActionToken() {
        if (actionTokens > 0) {
            actionTokens--;
        } else {
            // put-in: throw no more action tokens exception
        }
    }

    public void returnActionToken() {
        actionTokens++;
    }

    public void placeRiceBlock() {
        if (riceBlocks > 0) {
            riceBlocks--;
        } else {
            // put-in: throw no more rice blocks exception
        }
    }

    public void returnRiceBlock() {
        riceBlocks++;
    }

    public void placeVillageBlock() {
        if (villageBlocks > 0) {
            villageBlocks--;
        } else {
            // put-in: throw no more village blocks exception
        }
    }

    public void returnVillageBlock() {
        villageBlocks++;
    }

    public void placeTwoBlock() {
        if (twoBlocks > 0) {
            twoBlocks--;
        } else {
            // put-in: throw no more two blocks exception
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
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).compare(c) > 0) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public boolean hasCard(PalaceCard p) {
        boolean ret = false;
        for(PalaceCard c : cards)
        {
            if(p.sameCardAs(c))
            {
                ret = true;
                break;
            }
        }
        if (ret == false)
        {
            //put-in: player does not have that card exception
        }
        return ret;
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
        for (int i = 0; i < cards.size(); i++) {
            ret += cards.get(i).toString() + "\n";
        }
        return ret;
    }
}