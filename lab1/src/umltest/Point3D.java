package umltest;

/**
 * A test class for using the plug-in Green
 */

public abstract class Point3D implements Point {
	private double x;
	private double y;
	private double z;

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Returns the distance between one point and another.
	 */
	public double distanceTo(Point3D point) {
		return Math.sqrt((point.x - x) + (point.y - y) + (point.z - z));
	}

}
