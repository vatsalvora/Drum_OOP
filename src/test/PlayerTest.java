package test;

import controller.TurnController;
import model.Deck;
import model.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Testing all player stuff put together
 */
public class PlayerTest {

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Starting a new game.");

        in.nextLine();

        String[] names = {"Player1", "Player2", "Player3", "Player4"};

        TurnController tc = new TurnController(names);

        Player[] players = tc.getPlayers();

        Deck deck = new Deck();

        System.out.println("Drawing initial player cards.");

        in.nextLine();

        for(Player p : players)
        {
            p.addCard(deck.drawCard());
            p.addCard(deck.drawCard());
            p.addCard(deck.drawCard());
        }

        tc.putFestivalCard(deck.drawCard());

        System.out.println("Below is the starting information for all players.");

        in.nextLine();

        for(Player p : players)
        {
            System.out.println(p.toString());
        }

        in.nextLine();

        System.out.println("New game start!");

        boolean playing = true;

        while(playing) {
            System.out.println("The current player is: " + tc.getCurrentPlayer().getName());

            System.out.println("What would you like to do?");

            System.out.println("0. View your status");
            System.out.println("1. Place 3 tile block");
            System.out.println("2. Place 2 tile block");
            System.out.println("3. Place village tile");
            System.out.println("4. Place rice tile");
            System.out.println("5. Place irrigation tile");
            System.out.println("6. Place palace tile");
            System.out.println("7. Enlarge a palace");
            System.out.println("8. Place a developer in the lowlands");
            System.out.println("9. Place a developer in the mountains");
            System.out.println("10. Move a developer");
            System.out.println("11. Draw a palace card");
            System.out.println("12. View the current festival card");
            System.out.println("13. Draw the current festival card");
            System.out.println("14. Use an action token");
            System.out.println("15. Perform a palace festival");
            System.out.println("16. End turn");
            System.out.println("17. End game");
            System.out.println("You currently have " + tc.APLeft() + " AP left.");

            int decision = in.nextInt();
            try {
                switch (decision) {
                    case 0:
                        System.out.println(tc.getCurrentPlayer().toString());
                        break;
                    case 1:
                        tc.placeOtherBlock();
                        tc.incrementFamePoints(score(in));
                        break;
                    case 2:
                        tc.placeTwoBlock();
                        tc.incrementFamePoints(score(in));
                        break;
                    case 3:
                        tc.placeVillageBlock();
                        tc.incrementFamePoints(score(in));
                        break;
                    case 4:
                        tc.placeRiceBlock();
                        tc.incrementFamePoints(score(in));
                        break;
                    case 5:
                        tc.placeOtherBlock();
                        tc.incrementFamePoints(score(in));
                        break;
                    case 6:
                        tc.placeOtherBlock();
                        tc.incrementFamePoints(score(in));
                        break;
                    case 7:
                        System.out.println("Size of the new palace?");
                        int palaceSize = in.nextInt();
                        tc.incrementFamePoints(palaceSize / 2);
                        break;
                    case 8:
                        tc.placeDeveloper(1);
                        break;
                    case 9:
                        tc.placeDeveloper(2);
                        break;
                    case 10:
                        System.out.println("How much AP did the move take?");
                        int move = in.nextInt();
                        tc.performAction(move);
                        break;
                    case 11:
                        tc.drawCard(deck.drawCard());
                        break;
                    case 12:
                        System.out.println("Current festival card is " + tc.getFestivalCard());
                        break;
                    case 13:
                        tc.drawFestivalCard(deck.drawCard());
                        break;
                    case 14:
                        tc.useActionToken();
                        break;
                    case 15:
                        //perform palace festival
                        break;
                    case 16:
                        tc.nextTurn();
                        break;
                    case 17:
                        playing = false;
                        break;
                    default:
                        System.out.println("Make a real decision.");
                        break;
                }
            }
            catch(Exception e)
            {
                e.toString();
            }
        }

        System.out.println("Congratulations, the game is over!");
        System.out.println("Winner(s):");
        int maxScore = 0;
        for(Player p : players)
        {
            if(p.getFamePoints() > maxScore)
            {
                maxScore = p.getFamePoints();
            }
        }

        ArrayList<Player> winners = new ArrayList<Player>();

        for(Player p : players)
        {
            if(p.getFamePoints() == maxScore)
            {
                winners.add(p);
            }
        }

        for(Player p : winners)
        {
            System.out.println(p.getName());
        }
    }

    public static int score(Scanner in)
    {
        System.out.println("How many fame points does this action give?");
        return in.nextInt();
    }
}
