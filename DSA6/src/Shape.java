/**
 * 
 * @author Nicholas Senador
 * 
 *         Assignment #6 CSc 2720 Data Structures
 * 
 *         PURPOSE: This purpose of this program is to create three-dimensional
 *         shapes using the shapeInterface interface. The abstract classes will
 *         extend the interface into different categories of shapes such as
 *         prisms and radius based shapes. Shapes such as spheres, cubes, etc.
 *         will extend these abstract classes. Each shape will have its own
 *         methods for getting values for volume, surface area, etc.
 * 
 *         SOLUTION: All shapes need a method to get volume and surface area.
 *         These methods will be declared in the shapeInterface interface. There
 *         will be two categories of shapes: prisms and radius based shapes.
 *         Abstract classes of Prism and radiusType will implement
 *         prismInterface. Each shape will will extend its corresponding type
 *         and implement volume and surface area methods.
 * 
 *         DATA STRUCTURES: User defined structures: Cube, Box,
 *         rectangularPrism, triangularPrism, Sphere, Cylinder, Ball - all hold
 *         values for its three-dimensional shape type
 * 
 *         HOW TO USE: Running the program will make an object of each shape and
 *         print each method for each object. To use the code, create your own
 *         shape from the classes provided and use the methods within the
 *         classes.
 *
 */
public class Shape {
	public static void main(String[] args) {
		// Cube test
		Prism cb = new Cube(5);
		System.out.println("Cube sides: " + cb.getSides());
		System.out.println("Cube volume: " + cb.getVolume());
		System.out.println("Cube surface area: " + cb.getSurfArea());

		System.out.println();

		// Box test
		Box amazon = new Box(3);
		amazon.insertItem("Gift");
		System.out.println("Box sides: " + amazon.getSides());
		System.out.println("Box volume: " + amazon.getVolume());
		System.out.println("Box surface area: " + amazon.getSurfArea());

		System.out.println();

		// Rectangular Prism test
		Prism rectPrism = new rectangularPrism(1, 2, 3);
		System.out.println("Rectangular prism sides: " + rectPrism.getSides());
		System.out.println("Rectangular prism volume: " + rectPrism.getVolume());
		System.out.println("Rectangular prism surface area: " + rectPrism.getSurfArea());

		System.out.println();

		// Triangular Prism test
		Prism triPrism = new triangularPrism(2, 2, 2, 2);
		System.out.println("Triangular prism sides: " + triPrism.getSides());
		System.out.println("Triangular prism volume: " + triPrism.getVolume());
		System.out.println("Triangular prism surface area: " + triPrism.getSurfArea());

		System.out.println();

		// Sphere test
		radiusType sph = new Sphere(7);
		sph.printCircleAreaForm();
		System.out.println("Sphere volume: " + sph.getVolume());
		System.out.println("Sphere surface area: " + sph.getSurfArea());
		System.out.println("Sphere diamater: " + sph.getDiameter());

		System.out.println();

		// Ball test
		Ball b = new Ball(2);
		b.printSound();
		System.out.println("Ball volume: " + b.getVolume());
		System.out.println("Ball surface area: " + b.getSurfArea());
		System.out.println("Ball diameter: " + b.getDiameter());

		System.out.println();

		// Cylinder test
		Cylinder cyl = new Cylinder(2, 3);
		System.out.println("Cyclinder volume: " + cyl.getVolume());
		System.out.println("Cylinder surface area: " + cyl.getSurfArea());
		System.out.println("Cylinder diamater: " + cyl.getDiameter());
		System.out.println("Cyclinder base area: " + cyl.getBaseArea());
	}
}
