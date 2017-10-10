public class Fraction {
	private int num;
	private int denom;
	
	public Fraction() {
		this.num = 0;
		this.denom = 1;
	}
	
	public Fraction(int n, int d) {
		this.num = n;
		if (d == 0) {
			System.out.println("CANNOT HAVE 0 AS DENOMINATOR");
			return;
		}
		this.denom = d;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int getDenom() {
		return this.denom;
	}
	
	public void setNum(int n) {
		this.num = n;
	}
	
	public void setDenom(int d) {
		if (d == 0) {
			System.out.println("CANNOT HAVE 0 AS DENOMINATOR");
			return;
		}
		this.denom = d;
	}
	
	public void print() {
		System.out.println(this.num + "/" + this.denom);
	}
	
	public Fraction add(Fraction a) {
		Fraction newFrac = new Fraction();
		if (this.denom == a.denom) {
			newFrac.setNum(this.num + a.num);
			newFrac.setDenom(this.denom);
		} else {
			newFrac.setDenom(this.denom * a.denom);
			newFrac.setNum((this.num * a.denom) + (a.num * this.denom));
		}
		return newFrac;
	}
}
