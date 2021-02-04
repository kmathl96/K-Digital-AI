package sec01;

class Person {
	int age;
	String name;
	
	public Person() {
	}
	public Person(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "�̸�:" + name + ", ����:" + age;
	}
}

class Student extends Person {
	String major;
	public Student() {
	}
	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+", ����:"+major;
	}
}

class Teacher extends Person {
	String department;

	public Teacher() {}
	public Teacher(String name, int age, String department) {
		super(name, age);
		this.department = department;
	}
	@Override
	public String toString() {
		return super.toString() + ", �μ�:" + department;
	}

}
public class PolynoTest {

	public static void main(String[] args) {
		Person s1 = new Student("�ڳ���",33,"��ۿ���");
//		s1.getMajor();
		System.out.println(s1);
		
		Person[] pers = new Person[2];
		pers[0] = new Student("�ڳ���", 33, "��ۿ���");
		pers[1] = new Teacher("������", 55, "����������");
		System.out.println(pers[0].toString());
		System.out.println(pers[1].toString());
	}
}