import java.util.Scanner;
public class Blackjack {
	public static void main(String[] args) {
		String choice;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Blackjack!");
		// Set up the deck.
		Deck deckOfCards = new Deck();
		while (true) {
			// Shuffle the deck before each round.
			deckOfCards.shuffle();
			System.out.println("Shuffling...");
			// Deal the house's hand.
			Hand houseHand = new Hand(deckOfCards);
			System.out.printf("House's Hand:%n%s%nunknown%n", houseHand.getHand()[0].toString());
			// Deal the player's hand.
			Hand yourHand = new Hand(deckOfCards);
			System.out.printf("Your Hand:%n%s%n%s%nScore: %d%n",
					yourHand.getHand()[0].toString(),
					yourHand.getHand()[1].toString(),
					yourHand.getScore());
			while (true) {
				// Automatically stop when bust or 21.
				if (yourHand.getScore() > 20) {
					break;
				} else {
					// Hit or stay loop.
					System.out.println("Hit or Stay?");
					while (true) {
						choice = input.nextLine();
						if (choice.toLowerCase().equals("hit") | choice.toLowerCase().equals("stay")) {
							break;
						} else {
							System.out.println("Please type in either hit or stay.");
						}
					}
					// Adds new card on hit. Updates score.
					if (choice.toLowerCase().equals("hit")) {
						yourHand.addCard(deckOfCards);
						System.out.printf("New card: %s%nNew score: %d%n",
								yourHand.getHand()[yourHand.getCardCount()-1].toString(),
								yourHand.getScore());
					} else {
						// Exits on stay.
						break;
					}
 				}
			}
			// Inform upon bust.
			if (yourHand.getScore() > 21) {
				System.out.println("You bust!");
			}
			// House's turn. Based on traditional house rules.
			// Reveal house's hidden card.
			System.out.printf("House's Turn%nHouse's hidden card: %s%n", houseHand.getHand()[1].toString());
			while (true) {
				// House always hits when house's score is 16 or less.
				if (houseHand.getScore() > 16) {
					break;
				} else {
					houseHand.addCard(deckOfCards);
					System.out.printf("Hit: %s%n", houseHand.getHand()[houseHand.getCardCount()-1].toString());
				}
			}
			// Reveal house's final score.
			System.out.printf("House's Score: %d%n", houseHand.getScore());
			if (houseHand.getScore() > 21) {
				System.out.println("House bust!");
			}
			// Determine winner.
			if (houseHand.getScore() == yourHand.getScore()) {
				System.out.printf("It's a tie! %d-%d%n", yourHand.getScore(), houseHand.getScore());
			} else if (houseHand.getScore() > 21 && yourHand.getScore() > 21) {
				System.out.printf("It's a tie! %d-%d%n", yourHand.getScore(), houseHand.getScore());
			} else if (houseHand.getScore() > 21 && yourHand.getScore() <= 21) {
				System.out.printf("You win! %d-%d%n", yourHand.getScore(), houseHand.getScore());
			} else if (houseHand.getScore() <= 21 && yourHand.getScore() > 21) {
				System.out.printf("You lose! %d-%d%n", yourHand.getScore(), houseHand.getScore());
			} else if (houseHand.getScore() > yourHand.getScore()) {
				System.out.printf("You lose! %d-%d%n", yourHand.getScore(), houseHand.getScore());
			} else if (houseHand.getScore() < yourHand.getScore()) {
				System.out.printf("You win! %d-%d%n", yourHand.getScore(), houseHand.getScore());
			} else {
				System.out.println("This was never supposed to happen...");
			}
			// Shuffle and play again, or exit.
			System.out.println("Would you like to play again? Yes or no?");
			while (true) {
				choice = input.nextLine();
				if (choice.toLowerCase().equals("yes") | choice.toLowerCase().equals("no")) {
					break;
				} else {
					System.out.println("Please type in either yes or no.");
				}
			}
			if (choice.toLowerCase().equals("yes")) {
				continue;
			} else {
				System.out.println("Thanks for playing!");
				break;
			}
		}
		input.close();
	}
}
