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
		return "이름:" + name + ", 나이:" + age;
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
		return super.toString()+", 전공:"+major;
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
		return super.toString() + ", 부서:" + department;
	}

}
public class PolynoTest {

	public static void main(String[] args) {
		Person s1 = new Student("박나래",33,"방송연예");
//		s1.getMajor();
		System.out.println(s1);
		
		Person[] pers = new Person[2];
		pers[0] = new Student("박나래", 33, "방송연예");
		pers[1] = new Teacher("나선생", 55, "교육정보부");
		System.out.println(pers[0].toString());
		System.out.println(pers[1].toString());
	}
}