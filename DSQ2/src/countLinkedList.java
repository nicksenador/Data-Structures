import java.util.*;

public class countLinkedList {
	
	public static void main (String[] args) {
		LinkedList<Integer> a = makeLinkedList();
		int x = countLinkedList(a);
		System.out.println(x);
	}
	
	public static LinkedList makeLinkedList() {
		LinkedList<Integer> l = new LinkedList();
		Random rand = new Random();
		for (int i = 0; i < 50; i ++) {
			l.add(rand.nextInt(99) + 1);
		}
		return l;
	}
	
	public static int countLinkedList(LinkedList l) {
		if (l.peekFirst() == null) {
			return 0;
		} else {
			l.pollFirst();
			return 1 + countLinkedList(l);
		}
	}
}
