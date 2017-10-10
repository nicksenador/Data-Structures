/**
 * 
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this class is to create an abstract class for
 *         prisms that implements shapeInterface. Prisms have their special
 *         property of having 6 sides. Prisms can call getSides to get the value
 *         of 6.
 */
public abstract class Prism implements shapeInterface {
	/**
	 * This method returns the volume of a prism shape.
	 */
	public abstract double getVolume();

	/**
	 * This method returns the surface area of a prism shape.
	 */
	public abstract double getSurfArea();

	/**
	 * 
	 * @return int sides of a prism object. always = 6.
	 */
	public int getSides() {
		return 6;
	}
}
