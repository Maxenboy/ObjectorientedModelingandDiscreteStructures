package umltest;

/**
 * A test class for using the plug-in Green
 */

public abstract class Point2D implements Point {
	private double x;
	private double y;

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the distance between one point and another.
	 */
	public double distanceTo(Point2D point) {
		return Math.sqrt((point.x - x) + (point.y - y));
	}

}
