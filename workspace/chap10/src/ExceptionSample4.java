class A {}
class B extends A {}
class C extends A {}
public class ExceptionSample4 {

	public static void main(String[] args) {
		A a = new B();
//		C c = (C)a;
		if (a instanceof C) {
			C c = (C)a;
			System.out.println("�����");
		} else {
			System.out.println("������� ����");
		}
		try {
			C c = (C)a;
		} catch (ClassCastException e) {
			System.out.println("Ŭ���� ĳ���� ����");
		}
	}
}
