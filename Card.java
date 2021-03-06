// Card.java
public class Card {
	private String face;
	private String suit;
	private int value;
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
		// Assigns value based on the card's face.
		switch (face) {
		case "Ace":
			value = 11;
			break;
		case "Two":
			value = 2;
			break;
		case "Three":
			value = 3;
			break;
		case "Four":
			value = 4;
			break;
		case "Five":
			value = 5;
			break;
		case "Six":
			value = 6;
			break;
		case "Seven":
			value = 7;
			break;
		case "Eight":
			value = 8;
			break;
		case "Nine":
			value = 9;
			break;
		case "Ten":
			value = 10;
			break;
		case "Jack":
			value = 10;
			break;
		case "Queen":
			value = 10;
			break;
		case "King":
			value = 10;
			break;
		}
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getFace() {
		return face;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
	public String toString() {
		return face + " of " + suit;
	}
}
