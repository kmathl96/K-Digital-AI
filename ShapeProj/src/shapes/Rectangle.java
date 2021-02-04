package shapes;

public class Rectangle extends Shape implements IAngle {
	int width;
	int height;
	
	public Rectangle() {}
	public Rectangle(String color, int x, int y) {
		this.color = color;
		this.width = x;
		this.height = y;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public void draw() {
		System.out.println("[Rectangle-color:"+getColor()+",width:"+width+",height:"+height+"]");
	}
}