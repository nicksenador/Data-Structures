//Nicholas Senador

/* SOLUTION to Card class
 * 	a card has two values, a rank, and a suit. the default constructor and constructor with these two paramaters can set these values.
 * 	i will also implement getters and setters for both rank and suit for the card class
 * 	I will also need a toString method to people to print what each card is.
 * 		Ranks 11-14 will need to be converted into Jack, Queen, King, and Ace respectively
 * 
 * DATA STRUCTURES
 * 	 I just need an int for the rank and a string for the suit.
 * 
 * HOW TO USE
 * 	The user can create a Card with two constructors, Card() or Card(int, String). The getters and setters can be called to get or set ranks and suits for card objects. 
 * 	And the toString method can be called to convert the card into a string
 * 
 * PURPOSE of this class
 * 	The purpose of this class is to be able to make card objects and set the values of rank and suit for each card.
 */
public class Card {
	public int rank;
	public String suit;

	public Card() {
		rank = 14;
		suit = "Spades";
	}
	
	//@param r > 0
	//@param s
	public Card(int r, String s) {
		rank = r;
		suit = s;
	}
	
	//@return int > 0
	public int getRank() {
		return this.rank;
	}
	
	//@return String
	public String getSuit() {
		return this.suit;
	}
	
	//@param r > 0
	public void setRank(int r) {
		this.rank = r;
	}
	
	//@param s
	public void setSuit(String s) {
		this.suit = s;
	}
	
	//@return String
	public String toString() {
		String s;
		switch (this.rank) {
		case 11:
			s = "Jack";
			break;
		case 12:
			s = "Queen";
			break;
		case 13:
			s = "King";
			break;
		case 14:
			s = "Ace";
			break;
		default:
			s = Integer.toString(this.rank);
		}
		s += " of " + this.suit;
		return s;
	}
}
