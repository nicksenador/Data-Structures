import java.util.*;

public class Deck {
	public ArrayList<Card> deck = new ArrayList<Card>();
	String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
	
	public Deck() {
		for (int i = 0; i < suits.length; i ++) {
			for (int j = 2; j <= 14; j ++) {
				deck.add(new Card(j, suits[i]));
			}
		}
		
	}
	
	public void displayCards() {
		for (int i = 0; i < deck.size(); i ++) {
			System.out.println(deck.get(i).toString());
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.deck, new Random(System.nanoTime()));
	}
}
