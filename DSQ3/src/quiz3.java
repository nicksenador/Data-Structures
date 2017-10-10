import java.util.*;

public class quiz3 {
	public static void main(String[] args) {
		int n;
		ArrayList<Integer> a = new ArrayList();
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number for n :");
		n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			a.add(rand.nextInt(99) + 1);
		}
		long starttime = System.currentTimeMillis();
		Collections.sort(a);
		long stoptime = System.currentTimeMillis();
		double totaltime = (stoptime - starttime)/1000.0;
		System.out.println("Time elapsed : " + totaltime + " seconds");
		double bigO = totaltime/(2.5*Math.pow(10, 9));
		System.out.println("Big-O : " + bigO);
	}
}
