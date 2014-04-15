package test;

import controller.TurnController;
import model.*;
import java.util.*;

public class FestivalTest {
	public static void main(String[] args) {
		String playerNames[] = { "Bob", "Dave", "Stan", "Matt" };

		TurnController turnController = new TurnController(playerNames);

		Player[] players = turnController.getPlayers();

		Deck deck = new Deck();
		ArrayList<PalaceCard> startingDeck = deck.getDeck();

		for (int i = 0; i < startingDeck.size(); i++) {
			System.out.println(startingDeck.get(i).toString());
		}

		for (int i = 0; i < players.length; i++) {
			players[i].addCard(deck.drawCard());
			players[i].addCard(deck.drawCard());
			players[i].addCard(deck.drawCard());
		}

		System.out.println();

		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].toString());
		}
		turnController.drawFestivalCard(deck.drawCard());

		System.out.println();
		System.out.println("Palace Festival Card: " + turnController.getFestivalCard());
		System.out.println();
		String[] eligible = { "red", "blue", "yellow", "green" };

		turnController.startFestival(eligible);

		ArrayList<Player> festivalPlayers = turnController.getFestivalPlayers();

		for (int i = 0; i < festivalPlayers.size(); i++) {
			System.out.println(festivalPlayers.get(i).getName());
		}

		System.out.println();

		while (!turnController.festivalOver()) {

			System.out.println("Current player in festival: " + turnController.getCurrentFestivalPlayer().getName());
			System.out.println("What would you like to do?");
			System.out.println("1. View the palace festival card.");
			System.out.println("2. View your palace cards");
			System.out.println("3. Play a palace card");
			System.out.println("4. Drop out of the palace festival");

			Scanner in = new Scanner(System.in);

			int decision = in.nextInt();

			System.out.println();

			switch (decision) {
			case 1:
				System.out.println("Palace Festival Card: " + turnController.getFestivalCard());
				System.out.println();
				break;
			case 2:
				Player current = turnController.getCurrentFestivalPlayer();
				ArrayList<PalaceCard> cards = current.getCards();
				System.out.println("Your palace cards:");
				System.out.println(cards.size());
				for (int i = 0; i < cards.size(); i++) {
					// Returns a null pointer exception only for the first
					// player for some reason, saying he has 1 more card than he
					// actually has
					System.out.println(cards.get(i).toString());
				}
				System.out.println();
				break;
			case 3:
				System.out.println("What card would you like to place?");
				System.out.println("1. Mask");
				System.out.println("2. Drum");
				System.out.println("3. Puppet");
				System.out.println("4. Mask Drum");
				System.out.println("5. Drum Puppet");
				System.out.println("6. Puppet Mask");
				decision = in.nextInt();
				System.out.println();
				switch (decision) {
				case 1:
					turnController.playCard("MASK", "NONE");
					deck.discardCard(new PalaceCard("MASK", "NONE"));
					break;
				case 2:
					turnController.playCard("DRUM", "NONE");
					deck.discardCard(new PalaceCard("DRUM", "NONE"));
					break;
				case 3:
					turnController.playCard("PUPPET", "NONE");
					deck.discardCard(new PalaceCard("PUPPET", "NONE"));
					break;
				case 4:
					turnController.playCard("MASK", "DRUM");
					deck.discardCard(new PalaceCard("MASK", "DRUM"));
					break;
				case 5:
					turnController.playCard("DRUM", "PUPPET");
					deck.discardCard(new PalaceCard("DRUM", "PUPPET"));
					break;
				case 6:
					turnController.playCard("PUPPET", "MASK");
					deck.discardCard(new PalaceCard("PUPPET", "MASK"));
					break;
				default:
					break;
				}
				break;
			case 4:
				turnController.freezeFestivalPlayer();
				break;
			default:
				break;
			}
		}

		System.out.println("Festival Over!");
		System.out.println("Winner(s): ");
		ArrayList<Player> victors = turnController.getVictors();
		for (int i = 0; i < victors.size(); i++) {
			System.out.println(victors.get(i).getName());
		}
	}
}