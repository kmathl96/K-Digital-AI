class A {
	class B {
		B() {} // 생성자
		int n; // 인스턴스 필드
		void method() {} // 인스턴스 메소드
//		static int sn; // static 필드 선언 불가능
//		static void smethod() {}; // static 메소드 선언 불가능
	}
}

class C {
	// static inner class
	static class D {
		D() {}; // 생성자
		int n; // 인스턴스 필드
		void method() {}; // 인스턴스 메소드
		static int sn; // static 필드
		static void smethod() {}; // static 메소드
	}
}

public class InnerClassTest {
	
	public static void func() {
		class F {
			F() {}; // 생성자
			int n; // 인스턴스 필드
			void method() {}; // 인스턴스 메소드
//			static int sn; // static 필드 선언 불가능
//			static void smethod(); // static 메소드 선언 불가능
		}
		F f = new F();
		f.method();
	}
	
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		b.method();
		b.n = 10;
		
		C.D d = new C.D(); // D가 static이라 C를 생성하지 않고도 쓸 수 있음
		d.n = 10;
		C.D.sn = 20;
		C.D.smethod();
	}
}
