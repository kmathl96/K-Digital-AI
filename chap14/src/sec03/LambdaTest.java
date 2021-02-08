package sec03;

@FunctionalInterface
interface MyFunctionalInterface {
	public void method(int x);
//	public void method2(int x); // @FunctionalInterface ������̼��� ���̸� �ϳ��� �Լ��� ����
}
public class LambdaTest {

	public static void main(String[] args) {
		MyFunctionalInterface nfi = new MyFunctionalInterface() {
			
			@Override
			public void method(int x) {
				System.out.println(x);
			}
		};
		nfi.method(100);
		
		MyFunctionalInterface nf = (x)->{ System.out.println(x); };
		nf.method(100);
		
		Runnable r = ()->{System.out.println("A");};
		Thread t = new Thread(r);
		t.start();
	}	
}