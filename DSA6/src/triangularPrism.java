/**
 * 
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this class is to be able to create a
 *         triangular prism object that extends the abstract class Prism.
 *         triangularPrism class implements volume and surface area functions
 *         specific to triangular prisms.
 */
public class triangularPrism extends Prism {

	private int baseA;
	private int baseB;
	private int baseC;
	private int height;

	/**
	 * This is the default constructor for triangularPrism. Sets the values of
	 * baseA, baseB, baseC, and height to 1.
	 */
	public triangularPrism() {
		this.baseA = 1;
		this.baseB = 1;
		this.baseC = 1;
		this.height = 1;
	}

	/**
	 * Another constructor for triangularPrism. Sets the values of baseA, baseB,
	 * baseC, and height to a, b, c, and h respectively.
	 * 
	 * @param a
	 *            int used to set baseA of triangularPrism. always > 0.
	 * @param b
	 *            int used to set baseB of triangularPrism. always > 0.
	 * @param c
	 *            int used to set baseC of triangulerPrism. always > 0.
	 * @param h
	 *            int used to set height of triangularPrism. always > 0.
	 */
	public triangularPrism(int a, int b, int c, int h) {
		this.baseA = a;
		this.baseB = b;
		this.baseC = c;
		this.height = h;
	}

	/**
	 * Returns volume of triangularPrism object.
	 */
	public double getVolume() {
		return 0.25 * this.height
				* Math.sqrt(-Math.pow(this.baseA, 4) + 2 * Math.pow(this.baseA * this.baseB, 2)
						+ 2 * Math.pow(this.baseA * this.baseC, 2) - Math.pow(this.baseB, 4)
						+ 2 * Math.pow(this.baseB * this.baseC, 2) - Math.pow(this.baseC, 4));
	}

	/**
	 * Returns volume of triangularPrism object.
	 */
	public double getSurfArea() {
		return this.baseA * this.height + this.baseB * this.height + this.baseC * this.height
				+ 0.5 * Math.sqrt(-Math.pow(this.baseA, 4) + 2 * Math.pow(this.baseA * this.baseB, 2)
						+ 2 * Math.pow(this.baseA * this.baseC, 2) - Math.pow(this.baseB, 4)
						+ 2 * Math.pow(this.baseB * this.baseC, 2) - Math.pow(this.baseC, 4));
	}
}
