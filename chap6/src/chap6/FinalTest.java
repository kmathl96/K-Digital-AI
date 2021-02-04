package chap6;

class MyClass {
	static final int num = 20; // 선언과 동시에 반드시 초기화
	public MyClass(int num) {
//		this.num = num; // 클래스 내 fianl 변수는 생성자나 메소드에변경 불가능
	}
	
}

public class FinalTest {
	public static void main(String[] args) {
		final int num = 10;
//		num = 20; // final 변수는 변경할 수 없음
		int num2 = 30;
		num2 = 50;
	}
}
