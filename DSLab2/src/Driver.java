public class Driver {
	
	public static void main (String args[]) {
		Deck d1 = new Deck();
		d1.displayCards();
		System.out.println("------------------");
		d1.shuffle();
		d1.displayCards();
	}
}
