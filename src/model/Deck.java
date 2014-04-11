package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<PalaceCard> deck = new ArrayList<PalaceCard>();
	private ArrayList<PalaceCard> discard = new ArrayList<PalaceCard>();

	public Deck() {
		for (int i = 0; i < 5; i++) {
			deck.add(new PalaceCard("MASK"));
			deck.add(new PalaceCard("DRUM"));
			deck.add(new PalaceCard("PUPPET"));
			deck.add(new PalaceCard("MASK", "DRUM"));
			deck.add(new PalaceCard("DRUM", "PUPPET"));
			deck.add(new PalaceCard("PUPPET", "MASK"));
		}
		shuffle();
	}

	public Deck(ArrayList<PalaceCard> reset) {
		deck = reset;
	}

	public ArrayList<PalaceCard> getDeck() {
		return deck;
	}

	public ArrayList<PalaceCard> getDiscard() {
		return discard;
	}

	private void shuffle() {
		Collections.shuffle(deck);
	}

	public void reset(ArrayList<PalaceCard> newDeck,
			ArrayList<PalaceCard> newDiscard) {
		deck = newDeck;
		discard = newDiscard;
	}

	public PalaceCard drawCard() {
		PalaceCard ret = deck.remove(deck.size() - 1);
		if (deck.isEmpty()) {
			deck = discard;
			shuffle();
			discard.clear();
		}
		return ret;
	}

	public void discardCard(PalaceCard c) {
		discard.add(c);
	}

	public void returnCard(PalaceCard c) {
		deck.add(c);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("The Deck pile is:\n");
		for (PalaceCard c : deck) {
			result.append(c + ",");
		}
		result.append("\nThe Discard pile is is:\n");
		for (PalaceCard c : discard) {
			result.append(c + ",");
		}
		return result.toString();
	}
}