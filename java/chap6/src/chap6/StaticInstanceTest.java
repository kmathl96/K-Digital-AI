package chap6;

class Test {
	int ival;
	static int sval; // Ŭ���� �ε� ��(���α׷� ���� ��) ���� �Ҵ�
	public void iMethod() {
		ival = 100; // instance �޼ҵ忡�� instance ���� ���� ����
		sval = 200; // instance �޼ҵ忡�� static ���� ���� ����
	}
	public static void sMethod() {
//		ival = 10; // static �޼ҵ忡���� instance ���� ���� �Ұ���
		sval = 20; // static �޼ҵ忡�� static ���� ���� ����
//		this.sval = 30; // static �޼ҵ�� this ��� �Ұ�
	}
}

public class StaticInstanceTest {
	public static void main(String[] args) {
		Test.sval = 10; // static ������ ��ü ���� ���� Ŭ���������� ���� ����
//		Test.ival = 20; // instance ������ Ŭ���������� ���� �Ұ���
		Test.sMethod(); // static �޼ҵ�� ��ü ���� ���� Ŭ���������� ȣ�� ����
//		Test.iMethod(); // instance �޼ҵ�� Ŭ���������� ���� �Ұ���
		Test t = new Test();
		t.ival = 20; // instance ������ �ݵ�� ��ü �����Ͽ� ���� ������ ���� �����ؾ� ��
		t.iMethod(); // ������ ��ü�� ���ؼ��� ȣ�� ����
	
	}
}
