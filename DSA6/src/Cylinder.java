/**
 * 
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this class is to be able to create a cylinder
 *         object that extends the radiusType abstract class and implement the
 *         volume, surface area, and diameter methods. Cylinder also has get
 *         base area function.
 */
public class Cylinder extends radiusType {

	private int height;
	private int radius;

	/**
	 * The default constructor for Cylinder. Sets the values for height and
	 * radius to 1.
	 */
	public Cylinder() {
		this.height = 1;
		this.radius = 1;
	}

	/**
	 * Another constructor for Cylinder. Sets the values of height and radius to
	 * h and r.
	 * 
	 * @param h
	 *            int used to set height of Cylinder. always > 0.
	 * @param r
	 *            int used to set radius of Cylinder. always > 0.
	 */
	public Cylinder(int h, int r) {
		this.height = h;
		this.radius = r;
	}

	/**
	 * Returns volume of Cylinder object.
	 */
	public double getVolume() {
		return Math.PI * this.radius * this.radius * this.height;
	}

	/**
	 * Returns surface area of Cylinder Object.
	 */
	public double getSurfArea() {
		return 2 * Math.PI * this.radius * this.height + 2 * Math.PI * this.radius * this.radius;
	}

	/**
	 * Returns the base area of a Cylinder object.
	 * 
	 * @return double base area of Cylinder object. Always > 0.
	 */
	public double getBaseArea() {
		return Math.PI * this.radius * this.radius;
	}

	/**
	 * Returns diameter of Cyclinder object.
	 */
	public int getDiameter() {
		return this.radius * 2;
	}
}
