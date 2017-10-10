
public class LinkedList {
	int n;
	Node next;

	public LinkedList() {
		n = 0;
		next = null;
	}
	
	public LinkedList(int x, Node n) {
		this.n = x;
		this.next = n;
	}
	
	public void insertAtStart(int x) {
		next = new Node(x, next);
	}
	
	
	
}
