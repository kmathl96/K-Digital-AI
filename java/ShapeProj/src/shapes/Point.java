package shapes;

public class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String xy() {
		return "("+x+", "+y+")";
	}
}
