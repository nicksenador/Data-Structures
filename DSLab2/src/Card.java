
public class Card {
	public int rank;
	public String suit;

	public Card() {
		rank = 14;
		suit = "Spades";
	}
	
	public Card(int r, String s) {
		rank = r;
		suit = s;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public void setRank(int r) {
		this.rank = r;
	}
	
	public void setSuit(String s) {
		this.suit = s;
	}
	
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
