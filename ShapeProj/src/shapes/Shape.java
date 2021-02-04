package shapes;

public abstract class Shape {
	String color;
	public void draw() {}
	public Shape() {}
	public Shape(String color) {
		super();
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}