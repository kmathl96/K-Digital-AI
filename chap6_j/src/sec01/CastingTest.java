package sec01;

class A {
	
}
class B extends A {
	
}
class C extends A {
	
}

public class CastingTest {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		A a1 = new B();
		A a2 = new C();
		B b1 = (B)a1;
//		B b2 = (B)c; // 형제 관계에서는 캐스팅 불가
		C c1 = (C)a2;
	}
}