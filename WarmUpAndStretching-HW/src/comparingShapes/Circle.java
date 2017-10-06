package comparingShapes;

/**
 * A simple circle.
 *
 * @author Matt Boutell.
 *         Created Dec 1, 2013.
 */
public class Circle implements Comparable<Circle> {
	// DONE: Make this Circle comparable to other Circles so it can be sorted. That is,
	// implement the Comparable<Circle> interface.
	
	private double radius;
	
	/**
	 * Creates a circle with the given radius
	 * @param radius 
	 */
	public Circle(double radius) {
		this.radius = radius;
	}
	
	/**
	 * @return The area of this circle.
	 */
	public double area() {
		return Math.PI * this.radius * this.radius;
	}
	
	/**
	 * @return The circumference of this circle.
	 */
	public double perimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public int compareTo(Circle o) {
		// TODO Auto-generated method stub.
		return (int)Math.signum(this.radius-o.radius);
	}
	
}
