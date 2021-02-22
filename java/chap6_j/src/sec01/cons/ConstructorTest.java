package sec01.cons;

class Person {
	Person(int age) {}
	Person(int age, String name) {}
}
public class ConstructorTest {

	public static void main(String[] args) {
//		Person p1 = new Person(); // 생성자를 추가하면 기본 생성자는 자동생성되지 않음
		Person p2 = new Person(20);
		Person p3 = new Person(30, "hong");
	}
}