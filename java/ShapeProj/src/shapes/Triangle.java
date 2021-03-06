package shapes;

public class Triangle extends Shape implements IAngle {
	Point[] pos = new Point[3];
	
	public Triangle() {}
	public Triangle(String color, Point x, Point y, Point z) {
		super(color);
		pos[0] = x;
		pos[1] = y;
		pos[2] = z;
	}
	public Triangle(String color, int x1, int x2, int y1, int y2, int z1, int z2) {
		super(color);
		pos[0] = new Point(x1,x2);
		pos[1] = new Point(y1,y2);
		pos[2] = new Point(z1,z2);
	}
	@Override
	public void draw() {
		System.out.println("[Triangle-color:"+getColor()+",pos1:"+pos[0].xy()+",pos2:"+pos[1].xy()+",pos3:"+pos[2].xy()+"]");
	}
}
