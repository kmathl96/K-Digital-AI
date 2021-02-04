package chap6;

class Calculator2 {
	public static int add(int x, int y) {
		return x+y;
	}
	public static int sub(int x, int y) {
		return x-y;
	}
	public static int mul(int x, int y) {
		return x*y;
	}
	public static double div(int x, int y) {
		return y==0? y:(double)(x/y);
	}
}

public class CalculatorTest2 {
	public static void main(String[] args) {
//		Calculator2 c2 = new Calculator2();
		System.out.println(Calculator2.add(10, 20));
		System.out.println(Calculator2.sub(10, 20));
		System.out.println(Calculator2.mul(20, 8));
		System.out.println(Calculator2.div(2, 3));
	}
}