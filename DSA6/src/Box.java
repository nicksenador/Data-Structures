/**
 * 
 * @author Nicholas Senador
 *
 *         PURPOSE: The purpose of this class is to be able to create box object
 *         that extends cube. Box uses Cube's constructor to set its edge value.
 *         Box also has special values of color, materials, and contents. It
 *         also has a method to store an item.
 */
public class Box extends Cube {
	public String color;
	public String material;
	public String contents;

	/**
	 * This is the default constructor for box. It calls the Cube constructor to
	 * set the value for edge and sets color to brown, material to cardboard,
	 * and contents to null.
	 * 
	 * @param x
	 *            int used to call cube's constructor to set this box's edge to
	 *            x. always > 0.
	 */
	public Box(int x) {
		super(x);
		this.color = "brown";
		this.material = "cardboard";
		this.contents = null;
	}

	/**
	 * This method sets the contents of the box to String s
	 * 
	 * @param s
	 *            String that is set to the contents of box.
	 */
	public void insertItem(String s) {
		this.contents = s;
	}
}
