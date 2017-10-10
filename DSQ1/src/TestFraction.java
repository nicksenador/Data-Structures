import java.util.*;

public class TestFraction {
	
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction();
		int x;
		System.out.println("Enter the numerator for fraction1");
		x = input.nextInt();
		f1.setNum(x);
		System.out.println("Enter the denominator for fraction1");
		x = input.nextInt();
		f1.setDenom(x);
		System.out.println("Enter the numerator for fraction2");
		x = input.nextInt();
		f2.setNum(x);
		System.out.println("Enter the denominator for fraction2");
		x = input.nextInt();
		f2.setDenom(x);
		System.out.println("Fraction1:");
		f1.print();
		System.out.println("Fraction2:");
		f2.print();
		System.out.println("Fraction1 + Fraction2:");
		f1.add(f2).print();
		
	}
}
