/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	private Card[] cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return false;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return -1;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		return null;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards[k];
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.length - 1; k >= size; k--) {
			rtn = rtn + cards[k];
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.length % 2) == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}

	public static void main(String[] args) {
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] suits = {"C", "D", "H", "S"};
		int[] points = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
		Deck deck = new Deck(ranks, suits, points);
		if (deck.size() == ranks.length * suits.length) {
			System.out.println("Good size");
		}
		Card last = deck.deal();
		for (int i = 1; i < ranks.length * suits.length; i++) {
			Card next = deck.deal();
			if (next.matches(last)) {
				System.out.println("Duplicate card");
			}
			last = next;
		}
		if (deck.isEmpty()) {
			System.out.println("Good isEmpty");
		}
		/* Uncomment the below lines once you have completed
		 * activity 4
		 */
		 // Deck alt = new Deck(ranks, suits, points);
		 // activity4Tester(deck, alt);
	}

	public static void activity4Tester(Deck deck, Deck alt) {
		deck.shuffle();
		if (deck.size() == alt.size()) {
			System.out.println("Good size after shuffle");
		}
		Card[] allCards = new Card[alt.size()];
		for (int i = 0; i < allCards.length; i++) {
			allCards[i] = alt.deal();
		}
		while (!deck.isEmpty()) {
			Card c = deck.deal();
			boolean found = false;
			for (int i = 0; i < allCards.length; i++) {
				if (allCards[i] != null && c.matches(allCards[i])) {
					allCards[i] = null;
					found = true;
				}
			}
			if (!found) {
				System.out.println("Could not find " + c);
			}
		}
	}
	
}
