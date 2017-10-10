/**
 * 
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this class is to be able to create a sphere
 *         object that extends the radiusType abstract class and implements its
 *         methods of volume, surface area, and diameter specific to a sphere.
 */
public class Sphere extends radiusType {

	protected int radius;

	/**
	 * This is the default constructor of Sphere. Sets the value of radius to 1.
	 */
	public Sphere() {
		this.radius = 1;
	}

	/**
	 * Another constructor for sphere. Sets the value of radius to r.
	 * 
	 * @param r
	 *            int to set radius of sphere. always > 0.
	 */
	public Sphere(int r) {
		this.radius = r;
	}

	/**
	 * Returns volume of a Sphere object.
	 */
	public double getVolume() {
		return (4.0 / 3) * Math.PI * Math.pow(this.radius, 3);
	}

	/**
	 * Returns surface area of a Sphere object.
	 */
	public double getSurfArea() {
		return 4 * Math.PI * this.radius * this.radius;
	}

	/**
	 * Return diameter of a Sphere object.
	 */
	public int getDiameter() {
		return this.radius * 2;
	}
}
