package test;


import controller.TurnController;
import model.Deck;
import model.PalaceCard;
import model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class FestivalTest {

    public FestivalTest() {
    }


    public void PerformFestival(TurnController tc, Deck d) {

        Player[] players = tc.getPlayers();

        System.out.println("\n\nPalace Festival Card: " + tc.getFestivalCard());
        System.out.println("");
        String[] eligible = {"red", "blue", "green", "yellow"};

        tc.startFestival(eligible);

        ArrayList<Player> festivalPlayers = tc.getFestivalPlayers();

        for (Player festivalPlayer : festivalPlayers) {
            System.out.println(festivalPlayer.getName());
        }

        System.out.println();

        while (!tc.isFestivalOver()) {

            System.out.println("Current player in festival: " + tc.getCurrentFestivalPlayer().getName());
            String toString = "What would you like to do?\n " +
                    "1. View the palace festival card.\n " +
                    "2. View your palace cards\n " +
                    "3. Play a palace card\n " +
                    "4. Drop out of the palace festival";
            System.out.println(toString);
            Scanner in = new Scanner(System.in);

            int decision = in.nextInt();

            System.out.println();
            try {
                switch (decision) {
                    case 1:
                        System.out.println("Palace Festival Card: " + tc.getFestivalCard() + "\n");
                        break;
                    case 2:
                        Player current = tc.getCurrentFestivalPlayer();
                        ArrayList<PalaceCard> cards = current.getCards();
                        System.out.println("Your palace cards:\n" + cards.size());
                        for (PalaceCard card : cards) {
                            // Returns a null pointer exception only for the first
                            // player for some reason, saying he has 1 more card than he
                            // actually has
                            System.out.println(card.toString());
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("What card would you like to place?");
                        String a = "1. Mask\n" +
                                "2. Drum\n" +
                                "3. Puppet\n" +
                                "4. Mask Drum\n" +
                                "5. Drum Puppet\n" +
                                "6. Puppet Mask\n";
                        System.out.println(a);
                        decision = in.nextInt();
                        System.out.println();
                        switch (decision) {
                            case 1:
                                tc.playCard("MASK", "NONE");
                                d.discardCard(new PalaceCard("MASK", "NONE"));
                                break;
                            case 2:
                                tc.playCard("DRUM", "NONE");
                                d.discardCard(new PalaceCard("DRUM", "NONE"));
                                break;
                            case 3:
                                tc.playCard("PUPPET", "NONE");
                                d.discardCard(new PalaceCard("PUPPET", "NONE"));
                                break;
                            case 4:
                                tc.playCard("MASK", "DRUM");
                                d.discardCard(new PalaceCard("MASK", "DRUM"));
                                break;
                            case 5:
                                tc.playCard("DRUM", "PUPPET");
                                d.discardCard(new PalaceCard("DRUM", "PUPPET"));
                                break;
                            case 6:
                                tc.playCard("PUPPET", "MASK");
                                d.discardCard(new PalaceCard("PUPPET", "MASK"));
                                break;
                            default:
                                break;
                        }
                        break;
                    case 4:
                        try {
                            tc.freezeFestivalPlayer();
                        } catch (StackOverflowError e) {
                            tc.endFestival();
                        }
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        System.out.println("Festival Over!");
        System.out.println("Winner(s): ");
        ArrayList<Player> victors = tc.getVictors();
        for (Player victor : victors) {
            System.out.println(victor.getName());
        }
/*
        PalaceCard mask = new PalaceCard("MASK");
        PalaceCard drum = new PalaceCard("DRUM");
        PalaceCard puppet = new PalaceCard("PUPPET");
        PalaceCard md = new PalaceCard("MASK", "DRUM");
        PalaceCard dp = new PalaceCard("DRUM", "PUPPET");
        PalaceCard pm = new PalaceCard("PUPPET", "MASK");

        System.out.println("Comparing Cards:");
        ArrayList<PalaceCard> list = new ArrayList<PalaceCard>();

        list.add(mask);
        list.add(drum);
        list.add(puppet);
        list.add(md);
        list.add(dp);
        list.add(pm);

        ArrayList<PalaceCard> invertedList = new ArrayList<PalaceCard>();

        PalaceCard mask2 = new PalaceCard("MASK");
        PalaceCard drum2 = new PalaceCard("DRUM");
        PalaceCard puppet2 = new PalaceCard("PUPPET");
        PalaceCard dm = new PalaceCard("DRUM", "MASK");
        PalaceCard pd = new PalaceCard( "PUPPET", "DRUM");
        PalaceCard mp = new PalaceCard("MASK", "PUPPET");

        invertedList.add(mask2);
        invertedList.add(drum2);
        invertedList.add(puppet2);
        invertedList.add(dm);
        invertedList.add(pd);
        invertedList.add(mp);

        for(PalaceCard p : list)
        {
            for(PalaceCard c : invertedList)
            {
                System.out.println("Palace cards: " + p.toString() + " and " + c.toString() + " are equal: " + c.sameCardAs(p));
            }
        }*/
    }
}