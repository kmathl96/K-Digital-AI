package sec01.cons;

class Person {
	Person(int age) {}
	Person(int age, String name) {}
}
public class ConstructorTest {

	public static void main(String[] args) {
//		Person p1 = new Person(); // �����ڸ� �߰��ϸ� �⺻ �����ڴ� �ڵ��������� ����
		Person p2 = new Person(20);
		Person p3 = new Person(30, "hong");
	}
}