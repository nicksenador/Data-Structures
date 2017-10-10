import java.util.*;

/**
 * 
 * @author Nicholas Senador
 * 
 * 
 *         Assignment #5 CSc 2720 Data Structures
 * 
 *         PURPOSE OF THIS PROGRAM: The purpose of this program is to take a
 *         randomly generated array of numbers and store them in a binary search
 *         tree using a linked list that I have created. After the values have
 *         been stored in the binary search tree, an infix recursive method will
 *         print out the values in the tree from smallest to largest.
 * 
 *         SOLUTION FOR PROGRAM: First I need to create an array of random
 *         numbers using Random class. This array needs to be passed to another
 *         method(createBSTree) that puts the numbers in a tree. This method
 *         will go through the array calling addNum(LinkedList L, int x) for
 *         every value. The recursive addNum will traverse the tree until
 *         tree.prev is null for x < tree's data or tree.next is null for x >=
 *         tree's data. addNum will return the updated tree. Next is the infix
 *         recursive method to display the data of the tree in order.
 *         printTree(LinkedList l) will traverse the LinkedList for every
 *         subtree in LinkedList, if the subtree is null, the previous call will
 *         print it's value and start traversing the subtrees on it's left side.
 * 
 *         DATA STRUCTURES: LinkedList to store the tree and various subtrees.
 *         Array to store the random numbers.
 * 
 *         HOW TO USE: Running the program will print 100 random numbers ranging
 *         from `1-99 each separated by a colon. On the next line, the recursive
 *         method, printTree, will print the sorted values in order from the
 *         binary search tree.
 *
 */
public class BSTree {

	/**
	 * This is the main method of the program. It calls genArray to generate a
	 * random array. Then calls the method to print the array. Then created the
	 * binary search tree from linked list calling createBSTree passing the
	 * array. Then calls printTree passing the binary search tree of linked
	 * list.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = genArray();
		print(nums);
		LinkedList BSTree = createBSTree(nums);
		printTree(BSTree);
	}

	/**
	 * This method generates an array of length 100 with random variables from 1
	 * to 99 using the Random class from the java library. It then returns the
	 * array.
	 * 
	 * @return - array of type int of length 100 of random variables ranging
	 *         from 1 to 99(inclusive, inclusive)
	 */
	public static int[] genArray() {
		int[] a = new int[100];
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			a[i] = rand.nextInt(99) + 1;
		}
		return a;
	}

	/**
	 * This method prints a passed int type array that is not null in sequential
	 * order with each variable separated by a colon.
	 * 
	 * @param nums
	 *            - array of type int that is not null used to print
	 *            sequentially
	 */
	public static void print(int[] nums) {
		String s = "";
		for (int i = 0; i < nums.length; i++) {
			s += nums[i] + ":";
		}
		System.out.println(s);
	}

	/**
	 * This method creates a binary search tree from an array of int. It first
	 * creates a new LinkedList calling the default constructor to set the data
	 * to the first value in the array. It then goes through the array calling
	 * addNum passing the tree and the variable. Then it returns the tree.
	 * 
	 * @param nums
	 *            - array of type int that is not null used to add numbers to
	 *            the binary search tree
	 * @return - LinkedList that is not null containing the binary search tree
	 */
	public static LinkedList createBSTree(int[] nums) {
		LinkedList tree = new LinkedList(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			addNum(tree, nums[i]);
		}
		return tree;
	}

	/**
	 * This is a recursive method that will traverse the tree until x is able to
	 * be set to tree.prev for x < tree.data or tree.next otherwise. It calls
	 * itself with tree.prev if the current tree's tree.prev is not null for x <
	 * tree.data and vice versa for otherwise. It then returns the updated tree
	 * or subtree.
	 * 
	 * @param tree
	 *            - LinkedList that is not null used to check if x < tree.data
	 *            or x >= tree.data(else)
	 * @param x
	 *            - int value ranging from 1 to 99 (inclusive, inclusive) to
	 *            compare with tree.data
	 * @return - LinkedList with binary search tree or subtree stored that is
	 *         not null
	 */
	public static LinkedList addNum(LinkedList tree, int x) {
		if (x < tree.data) {
			if (tree.prev == null) {
				tree.prev = new LinkedList(x);
			} else {
				tree = addNum(tree.prev, x);
			}
		} else {
			if (tree.next == null) {
				tree.next = new LinkedList(x);
			} else {
				tree = addNum(tree.next, x);
			}
		}
		return tree;
	}

	/**
	 * This recursive method prints the infix form of a binary search tree
	 * stored in a LinkedList by calling itself for each subtree for tree.prev,
	 * then printing tree.data followed by a colon, then calling itself for each
	 * subtree for tree.next.
	 * 
	 * @param tree
	 *            - LinkedList holding a binary search tree that is not null
	 *            used to print data in the form of infix
	 */
	public static void printTree(LinkedList tree) {
		if (tree != null) {
			printTree(tree.prev);
			System.out.print(tree.data + ":");
			printTree(tree.next);
		}
	}
}
