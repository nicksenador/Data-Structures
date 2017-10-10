/**
 * 
 * @author Nicholas Senador
 * 
 * 
 *         PURPOSE OF CLASS: The purpose of this class is to create by own
 *         LinkedList like the one in the java library. My linked list needs to
 *         have a data, a next linkedlist, and a previous linkedlist.
 * 
 *         DATA STRUCTURES: LinkedList to hold next and prev.
 * 
 *         HOW TO USE: Call LinkedList(int x) to create a new LinkedList object
 *         with the data set to x.
 * 
 *
 */
public class LinkedList {
	public Integer data;
	public LinkedList next;
	public LinkedList prev;

	/**
	 * This is the default constructor of LinkedList. It sets the passed int to
	 * this.data and the values of next and prev to null.
	 * 
	 * @param x
	 *            - int value of any possible value java can hold for int used
	 *            to store in the linkedlist's data
	 */
	public LinkedList(int x) {
		this.data = x;
		this.next = null;
		this.prev = null;
	}

}
