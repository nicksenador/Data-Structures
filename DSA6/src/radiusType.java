/**
 * 
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this class is to create an abstract class for
 *         radius-based shapes that implements shapeInterface. Radius type
 *         shapes have another function getDiameter specific to each shape.
 *         Radius type shapes also have the ability to call the formula for a
 *         the area of a circle.
 */
public abstract class radiusType implements shapeInterface {
	/**
	 * Returns volume of radiusType object.
	 */
	public abstract double getVolume();

	/**
	 * Returns surface area of radiusType object.
	 */
	public abstract double getSurfArea();

	/**
	 * returns diamater of radiusType object.
	 * 
	 * @return int diamater of radiusType object. always > 0.
	 */
	public abstract int getDiameter();

	/**
	 * Prints the forumula for the area of a circle for radiusType objects.
	 */
	public void printCircleAreaForm() {
		System.out.println("The formula for the area of a cirlce is pi * radius * radius.");
	}

}
