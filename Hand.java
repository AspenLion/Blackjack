// Hand.java
public class Hand {
	// Hand. Maximum amount of cards possible is 11,
	// thus hand array is set to 11.
	private Card[] hand = new Card[11];
	private int score = 0;
	// Keep a count of aces for score keeping.
	private int aceCount = 0;
	private int cardCount = 0;
	// Adds two cards when initializing a new hand.
	public Hand(Deck deck) {
		hand[cardCount] = deck.deal(); // Deal card.
		score += hand[cardCount].getValue(); // Increase score.
		if (hand[cardCount].getFace() == "Ace") { // Check if ace was dealt.
			aceCount++;
		}
		cardCount++;
		hand[cardCount] = deck.deal();
		score += hand[cardCount].getValue();
		if (hand[cardCount].getFace() == "Ace") {
			aceCount++;
		}
		cardCount++;
		if (score > 21 && aceCount > 0) { // If score is too high but an ace is present,
			aceCount--;                   // decrease ace's value by reducing score by 10.
			score -= 10;
		}
	}
	public int getScore() {
		return score;
	}
	// Add new card to hand. Goes through all value checks from above.
	public void addCard(Deck deck) {
		hand[cardCount] = deck.deal();
		score += hand[cardCount].getValue();
		if (hand[cardCount].getFace() == "Ace") {
			aceCount++;
		}
		cardCount++;
		if (score > 21 && aceCount > 0) {
			aceCount--;
			score -= 10;
		}
	}
	public int getCardCount() {
		return cardCount;
	}
	public Card[] getHand() {
		return hand;
	}
}
