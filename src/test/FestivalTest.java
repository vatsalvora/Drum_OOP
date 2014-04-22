package test;

import controller.TurnController;
import model.*;

import java.util.*;

public class FestivalTest {

    ArrayList<String> colors;

	public FestivalTest(ArrayList<String> c) {
        colors = c;
	}

	public void PerformFestival(TurnController tc, Deck d) {

		TurnController turnController = tc;

		Player[] players = turnController.getPlayers();

		Deck deck = d;

		System.out.println();

		System.out.println();
		System.out.println("Palace Festival Card: "
				+ turnController.getFestivalCard());
		System.out.println();

		turnController.startFestival(colors);

		ArrayList<Player> festivalPlayers = turnController.getFestivalPlayers();

		for (int i = 0; i < festivalPlayers.size(); i++) {
			System.out.println(festivalPlayers.get(i).getName());
		}

		System.out.println();

		while (!turnController.festivalOver()) {

			System.out.println("Current player in festival: "
					+ turnController.getCurrentFestivalPlayer().getName());
			System.out.println("What would you like to do?");
			System.out.println("1. View the palace festival card.");
			System.out.println("2. View your palace cards");
			System.out.println("3. Play a palace card");
			System.out.println("4. Drop out of the palace festival");

			Scanner in = new Scanner(System.in);

			int decision = in.nextInt();

			System.out.println();
			try {
				switch (decision) {
				case 1:
					System.out.println("Palace Festival Card: "
							+ turnController.getFestivalCard());
					System.out.println();
					break;
				case 2:
					Player current = turnController.getCurrentFestivalPlayer();
					ArrayList<PalaceCard> cards = current.getCards();
					System.out.println("Your palace cards:");
					System.out.println(cards.size());
					for (int i = 0; i < cards.size(); i++) {
						// Returns a null pointer exception only for the first
						// player for some reason, saying he has 1 more card
						// than he
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
					try {
						turnController.freezeFestivalPlayer();
					} catch (StackOverflowError e) {
						turnController.endFestival();
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
		ArrayList<Player> victors = turnController.getVictors();
		for (int i = 0; i < victors.size(); i++) {
			System.out.println(victors.get(i).getName());
		}
		/*
		 * PalaceCard mask = new PalaceCard("MASK"); PalaceCard drum = new
		 * PalaceCard("DRUM"); PalaceCard puppet = new PalaceCard("PUPPET");
		 * PalaceCard md = new PalaceCard("MASK", "DRUM"); PalaceCard dp = new
		 * PalaceCard("DRUM", "PUPPET"); PalaceCard pm = new
		 * PalaceCard("PUPPET", "MASK");
		 * 
		 * System.out.println("Comparing Cards:"); ArrayList<PalaceCard> list =
		 * new ArrayList<PalaceCard>();
		 * 
		 * list.add(mask); list.add(drum); list.add(puppet); list.add(md);
		 * list.add(dp); list.add(pm);
		 * 
		 * ArrayList<PalaceCard> invertedList = new ArrayList<PalaceCard>();
		 * 
		 * PalaceCard mask2 = new PalaceCard("MASK"); PalaceCard drum2 = new
		 * PalaceCard("DRUM"); PalaceCard puppet2 = new PalaceCard("PUPPET");
		 * PalaceCard dm = new PalaceCard("DRUM", "MASK"); PalaceCard pd = new
		 * PalaceCard( "PUPPET", "DRUM"); PalaceCard mp = new PalaceCard("MASK",
		 * "PUPPET");
		 * 
		 * invertedList.add(mask2); invertedList.add(drum2);
		 * invertedList.add(puppet2); invertedList.add(dm);
		 * invertedList.add(pd); invertedList.add(mp);
		 * 
		 * for(PalaceCard p : list) { for(PalaceCard c : invertedList) {
		 * System.out.println("Palace cards: " + p.toString() + " and " +
		 * c.toString() + " are equal: " + c.sameCardAs(p)); } }
		 */
	}
}