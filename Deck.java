// Deck.java
// Imports
import java.security.SecureRandom;;

public class Deck {
	// Random numbers used for shuffling.
	private static final SecureRandom randomNumbers = new SecureRandom();
	private Card[] deck = new Card[52];
	private int currentCard = 0;
	public Deck() {
		// Build all 52 cards in a deck.
		String[] faces = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
		String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
		for (int i = 0; i < 52; i++) {
			deck[i] = new Card(faces[i%13],suits[i/13]);
		}
	}
	// Shuffle by randomly swapping every card.
	public void shuffle() {
		currentCard = 0;
		for (int first = 0; first < 52; first++) {
			int second = randomNumbers.nextInt(52);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	// Deals a card by returning said card and incrementing through the deck.
	public Card deal() {
		if (currentCard < 52) {
			return deck[currentCard++];
		} else {
			return null;
		}
	}
}
