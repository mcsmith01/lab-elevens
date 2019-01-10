/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card1 = new Card("Ace", "Spades", 11);
		Card card2 = new Card("Ace", "Spades", 11);
		Card card3 = new Card("Two", "Clubs", 2);
		if (card1.matches(card2)) {
			System.out.println("Good match");
		}
		if (!card1.matches(card3)) {
			System.out.println("Good mismatch");
		}
		if (card1.rank().equals("Ace")) {
			System.out.println("Good rank");
		}
		if (card1.suit().equals("Spades")) {
			System.out.println("Good suit");
		}
		if (card1.pointValue() == 11) {
			System.out.println("Good point value");
		}
		if (card1.toString().equals("Ace of Spades (point value = 11)")) {
			System.out.println("Good toString");
		}
	}
}
