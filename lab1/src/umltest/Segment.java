package umltest;

public class Segment {
	private Point point1;
	private Point point2;

	public Segment(Point start, Point end) {
		this.point1 = start;
		this.point2 = end;
	}

	public double length() {
		return point1.distanceTo(point2);
	}
}
