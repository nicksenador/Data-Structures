/**
 * 
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this class is to make a cube object that
 *         extends the Prism abstract class. Cube implements getVolume and
 *         getSurfArea specific to the cube shape.
 */
public class Cube extends Prism {

	protected int edge;

	/**
	 * This is the default constructor of Cube. It sets the edge value to 1.
	 */
	public Cube() {
		this.edge = 1;
	}

	/**
	 * This method is another constructor of Cube. It sets the value of edge to
	 * x.
	 * 
	 * @param x
	 *            int value set to edge for Cube. Always > 0.
	 */
	public Cube(int x) {
		this.edge = x;
	}

	/**
	 * This method returns the volume for a Cube object.
	 */
	public double getVolume() {
		return this.edge * this.edge * this.edge;
	}

	/**
	 * This method returns the surface area for a Cube object.
	 */
	public double getSurfArea() {
		return 6 * this.edge * this.edge;
	}
}
