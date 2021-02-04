package sec01.val;

class MyClass {
	int iv;
	static int sv;
	
	void imethod() { // instance method
		System.out.println(iv); // instance 변수 접근 가능
		System.out.println(sv); // static 변수 접근 가능
		imethod2(); // instance 메소드 호출 가능
		smethod(); // static 메소드 호출 가능
	}
	void imethod2() {}
	static void smethod() { // static method
//		System.out.println(iv); // instance 변수 접근 불가능
		System.out.println(sv); // static 변수 접근 가능
//		imethod(); // instance 메소드 호출 불가능
		smethod2(); // static 메소드 호출 가능
	}
	static void smethod2() {}
}

public class StaticTest {

	public static void main(String[] args) {
		MyClass.smethod(); // 클래스명으로 호출 가능
	}
}