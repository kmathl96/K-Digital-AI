package chap6;

class MyClass {
	static final int num = 20; // ����� ���ÿ� �ݵ�� �ʱ�ȭ
	public MyClass(int num) {
//		this.num = num; // Ŭ���� �� fianl ������ �����ڳ� �޼ҵ忡���� �Ұ���
	}
	
}

public class FinalTest {
	public static void main(String[] args) {
		final int num = 10;
//		num = 20; // final ������ ������ �� ����
		int num2 = 30;
		num2 = 50;
	}
}
