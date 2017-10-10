/**
 * 
 * @author Nicholas Senador
 * 
 *         PURPOSE: The purpose of this class is to create an interface for all
 *         shapes. Every shape shares the common need to methods to get volume
 *         and get surface area.
 *
 */
public interface shapeInterface {
	/**
	 * This method returns the volume of a calling shape.
	 * 
	 * @return double volume of calling object. always > 0.
	 */
	public double getVolume();

	/**
	 * This method returns the surface area of a calling shape.
	 * 
	 * @return double surface area of calling object. always > 0.
	 */
	public double getSurfArea();
}
