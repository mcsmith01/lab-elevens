/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
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
