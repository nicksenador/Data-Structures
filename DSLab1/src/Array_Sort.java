import java.util.Random;

public class Array_Sort {
	
	public static void main (String args[]) {
		int randNums[] = new int[50];
		Random rand = new Random();
		for (int i = 0; i < 50; i ++) {
			randNums[i] = (rand.nextInt(100) + 1);
		}
		System.out.println("Before sorting:");
		for (int i = 0; i < 50; i ++) {
			System.out.print(randNums[i] + " : ");
		}
		System.out.println();
		
		int[] sorted = sort(randNums);
		
		System.out.println("After sorting:");
		for (int i = 0; i < 50; i ++) {
			System.out.print(sorted[i] + " : ");
		}
	}
	
	public static int[] sort(int[] a) {
		for (int k = 0; k < 50; k++){
			for (int i = 0;  i < 49; i ++) {
					if (a[i + 1] < a[i]){
						int temp = a[i + 1];
						a[i + 1] = a[i];
						a[i] = temp;
					}
			}
		}
		return a;
	}
	
}
