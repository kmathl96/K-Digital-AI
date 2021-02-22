package chap6;

class Number {
	int num;
	public void setNum(Number this, int num) {
		this.num = num;
	}
}

public class ThisDescTest {
	public static void main(String[] args) {
		Number n = new Number();
		n.setNum(10); // Number.setNum(n,10);
	}
}
