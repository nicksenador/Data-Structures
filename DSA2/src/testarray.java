//Nicholas Senador

//@author nsenador1

/*The purpose of this program is to create my own ArrayList data structure much
 * like the one that currently exists in java library. I will be creating a ArrayList
 * class that has methods to do most of the common functions available to the ArrayList
 * class that already exists in java. These methods will be tested in the driver, testarray.java.
 * I also need to create a Card class to make an array of objects in testarray.java.
 * 
 * SOLUTION to testarray.java
 * I'll divide all of the problems into methods.
 * The shuffle method will invoke the random class and take two random ints and switch the values of those locations in the deck arraylist.
 * The shuffle method will "shuffle" 20 times per Professor Bhola
 * 
 *SOLUTION to implement problems 1-10 listed in the assignment
 *0. ArrayList object - I will use java's array to build my ArrayList upon and declare size as an attribute to it
 *   The array will be of type object and will check consistency of object type in the add methods
 *1. default constructor - set int size to 10
 *2. constructor - takes int as parameter and sets size to n
 *3. ArrayList.add(object x) - for loop through array looking for next available null, then check for same type of objects as x, then this.array[index] = x. if all indexes in array are null, add x at [0]
 *if object exists in last index, size *=2, create new array of new size and recursively add objects
 *4. ArrayList.add(int index, object x) - if index > this.size - 1, this.size = index-1 and new array of new size recursively adding objects, this.array[index] = x. else, for loop to see if any objects in this.array, if so, check same objects consistency and this.array[index]=x, if not this.array[index] = x.
 *if object exists in last index, size*=2, create new array of new size and recursively add objects
 *5. public Object get(int index) - return this.array[index]
 *6. public int size() - return this.size
 *7. public boolean isEmpty() - for loop going through this.array, if this.array[index] does not = null return false. return true outside for loop. 
 *8. public boolean isIn(Object b) - for loop going through this.array, if this.array[index = b return true. return false outside for loop.
 *9. public int find(Object b) - for loop through this.array, if this.array[index] = b, return index. return -1 outside for loop.
 *10. public void remove(Object n) - call find function, if returned value != -1, new array, for loop to add back objects except index of returned value from find method
 *
 *SOLUTION to implement Card class
 * 	a card has two values, a rank, and a suit. the default constructor and constructor with these two paramaters can set these values.
 * 	i will also implement getters and setters for both rank and suit for the card class
 * 	I will also need a toString method to people to print what each card is.
 * 		Ranks 11-14 will need to be converted into Jack, Queen, King, and Ace respectively
 *DATA STRUCTURES for testarray.java
 * 	I will be using my own ArrayList and Card class objects!
 *
 *DATA STRUCTURES for ArrayList
 *int for size
 *array of type Object
 *
 *DATA STRUCTURES for Card class
 * int for rank, string for suit
 *
 *HOW TO USE
 *	ArrayList.java can be used to create arraylist objects. My ArrayList class can only hold Objects and only objects of the same type.
 *	Use any of the public methods in arraylist by calling the method you want with ArrayList.methodName(parameters)
 *	Card.java can be used to make card arrays. You can use any of the methods in Card.java by calling Card.methodName(parameters)
 *
 *CLASSES
 *	ArrayList.java - The purpose of this class is to make it so the user can make arraylist objects. It is also to define methods to create and manipulate methods of the arraylist class.
 *	Card.java - The purpose of this class is to be able to make card objects and set the values of rank and suit for each card.
 *	testarray.java - The purpose of this class is to test all of the methods in ArrayList.java using Card objects from Card.java.
 */

import java.util.*;
public class testarray {
	public static void main(String args[]) {
		ArrayList deck = createDeck();
		printDeck(deck);
		deck = shuffle(deck);
		System.out.println("===SHUFFLED===");
		printDeck(deck);
		System.out.println("===TESTING METHODS===");
		testMethods();
		
	}

	//@return deck
	public static ArrayList createDeck() {
		ArrayList deck = new ArrayList();
		String[] suits = {"Spades", "Jacks", "Hearts", "Diamonds"};
		//adding all cards to ArrayList, deck
		for (int i = 0; i < suits.length; i ++) {
			for (int j = 2; j < 15; j ++) {
				deck.add(new Card(j, suits[i]));
			}
		}
		return deck;
	}
	
	public static void printDeck(ArrayList deck) {
		for (int i = 0; i < deck.size(); i ++) {
			System.out.println(deck.get(i).toString());
		}
	}
	
	//shuffles deck 20 times, two random indexes and switches them
	// @param deck
	// @return deck is different from paramter deck
	public static ArrayList shuffle(ArrayList deck) {
		Random rand = new Random();
		int first;
		int second;
		for (int i = 0; i < 20; i ++) {
			first = rand.nextInt(deck.size());
			second = rand.nextInt(deck.size());
			Object temp = deck.get(first);
			deck.add(first, deck.get(second));
			deck.add(second, temp);
		}
		return deck;
	}
	
	public static void testMethods() {
		ArrayList test = new ArrayList();
		System.out.println("default constructor success");
		ArrayList test2 = new ArrayList(20);
		System.out.println("int constructor success");
		test.add(new Integer (1));
		System.out.println("add object success");
		test.add(1, new Integer(2));
		System.out.println("add object at index success");
		System.out.println(test.get(1));
		System.out.println(test.size());
		System.out.println(test.isEmpty());
		System.out.println(test.isIn(new Integer(1)));
		System.out.println(test.find(new Integer(1)));
		test.remove(new Integer(1));
		System.out.println("remove object success");
	}
	
}
