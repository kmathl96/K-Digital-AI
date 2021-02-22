interface IBase {
	void method();
}

abstract class CBase {
	abstract void cmethod();
}

public class AnonymousTest {

	public static void main(String[] args) {
		IBase b = new IBase() { // IBase�� ��� �޾� �͸� Ŭ������ �����ϰ� �������̵� ��, ������
			
			@Override
			public void method() {
				System.out.println("method ���� �޼���");
			}
		};
		b.method();
		
		CBase c = new CBase() {

			@Override
			void cmethod() {
				System.out.println("smethod ���� �޼���");
			}
		};
		c.cmethod();
	}
}