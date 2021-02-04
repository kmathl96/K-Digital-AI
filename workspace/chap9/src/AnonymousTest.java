interface IBase {
	void method();
}

abstract class CBase {
	abstract void cmethod();
}

public class AnonymousTest {

	public static void main(String[] args) {
		IBase b = new IBase() { // IBase를 상속 받아 익명 클래스를 정의하고 오버라이딩 후, 생성함
			
			@Override
			public void method() {
				System.out.println("method 구현 메서드");
			}
		};
		b.method();
		
		CBase c = new CBase() {

			@Override
			void cmethod() {
				System.out.println("smethod 구현 메서드");
			}
		};
		c.cmethod();
	}
}