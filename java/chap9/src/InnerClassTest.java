class A {
	class B {
		B() {} // ������
		int n; // �ν��Ͻ� �ʵ�
		void method() {} // �ν��Ͻ� �޼ҵ�
//		static int sn; // static �ʵ� ���� �Ұ���
//		static void smethod() {}; // static �޼ҵ� ���� �Ұ���
	}
}

class C {
	// static inner class
	static class D {
		D() {}; // ������
		int n; // �ν��Ͻ� �ʵ�
		void method() {}; // �ν��Ͻ� �޼ҵ�
		static int sn; // static �ʵ�
		static void smethod() {}; // static �޼ҵ�
	}
}

public class InnerClassTest {
	
	public static void func() {
		class F {
			F() {}; // ������
			int n; // �ν��Ͻ� �ʵ�
			void method() {}; // �ν��Ͻ� �޼ҵ�
//			static int sn; // static �ʵ� ���� �Ұ���
//			static void smethod(); // static �޼ҵ� ���� �Ұ���
		}
		F f = new F();
		f.method();
	}
	
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		b.method();
		b.n = 10;
		
		C.D d = new C.D(); // D�� static�̶� C�� �������� �ʰ� �� �� ����
		d.n = 10;
		C.D.sn = 20;
		C.D.smethod();
	}
}
