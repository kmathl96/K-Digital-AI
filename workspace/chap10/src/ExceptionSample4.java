class A {}
class B extends A {}
class C extends A {}
public class ExceptionSample4 {

	public static void main(String[] args) {
		A a = new B();
//		C c = (C)a;
		if (a instanceof C) {
			C c = (C)a;
			System.out.println("실행됨");
		} else {
			System.out.println("실행되지 않음");
		}
		try {
			C c = (C)a;
		} catch (ClassCastException e) {
			System.out.println("클래스 캐스팅 에러");
		}
	}
}
