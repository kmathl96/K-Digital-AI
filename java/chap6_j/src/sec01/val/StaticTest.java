package sec01.val;

class MyClass {
	int iv;
	static int sv;
	
	void imethod() { // instance method
		System.out.println(iv); // instance ���� ���� ����
		System.out.println(sv); // static ���� ���� ����
		imethod2(); // instance �޼ҵ� ȣ�� ����
		smethod(); // static �޼ҵ� ȣ�� ����
	}
	void imethod2() {}
	static void smethod() { // static method
//		System.out.println(iv); // instance ���� ���� �Ұ���
		System.out.println(sv); // static ���� ���� ����
//		imethod(); // instance �޼ҵ� ȣ�� �Ұ���
		smethod2(); // static �޼ҵ� ȣ�� ����
	}
	static void smethod2() {}
}

public class StaticTest {

	public static void main(String[] args) {
		MyClass.smethod(); // Ŭ���������� ȣ�� ����
	}
}