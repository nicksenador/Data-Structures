/**
 *
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this function is to be able to create a ball
 *         object that extends sphere class. Ball uses Sphere's constructor for
 *         radius and has specific value of color and specific method to print a
 *         ball's sound.
 */
public class Ball extends Sphere {

	private String color;

	/**
	 * Default constructor for Ball object. Calls Sphere's constructor to set
	 * the radius to x. Sets the value of color to "red".
	 * 
	 * @param x
	 *            int used to call Sphere's constructor to set radius to x.
	 *            always > 0.
	 */
	public Ball(int x) {
		super(x);
		this.color = "red";
	}

	/**
	 * This method prints the sound of a Ball object.
	 */
	public void printSound() {
		System.out.println("Bong!");
	}
}
