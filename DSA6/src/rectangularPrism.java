/**
 * 
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this class is to be able to create a
 *         rectangular prism object that extends the abstract class Prism.
 *         Rectangular Prism implements volume and surface area functions.
 */
public class rectangularPrism extends Prism {

	private int length;
	private int width;
	private int height;

	/**
	 * This is the default constructor for rectangularPrism. Sets the values for
	 * length, width, and height to 1.
	 */
	public rectangularPrism() {
		this.length = 1;
		this.width = 1;
		this.height = 1;
	}

	/**
	 * Another constructor for rectangularPrism. Set the values for length,
	 * width, and height to l, w, and h respectively.
	 * 
	 * @param l
	 *            int used to set length of rectangularPrism object. always > 0.
	 * @param w
	 *            int used to set width of rectangularPrism object. always > 0.
	 * @param h
	 *            int used to set height of rectangularPrism object. always > 0.
	 */
	public rectangularPrism(int l, int w, int h) {
		this.length = l;
		this.width = w;
		this.height = h;
	}

	/**
	 * Returns the volume of a rectangularPrism object.
	 */
	public double getVolume() {
		return this.length * this.width * this.height;
	}

	/**
	 * Returns the surface area of a rectangularPrism object.
	 */
	public double getSurfArea() {
		return 2 * (this.width * this.length + this.height * this.length + this.height * this.width);
	}
}
