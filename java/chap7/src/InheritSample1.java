class Person {
	int age;
	String name;
	
	public Person() {}
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public String info() {
		return "이름:"+name+", 나이:"+age;
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
}

class Student extends Person {
	String major;

	public Student(int age, String name,String major) {
		super(age, name);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String info() {
		return super.info()+", 전공:"+major;
	}
}

class Professor extends Person {
	String department;
	public Professor() {}
	public Professor(int age, String name, String department) {
		super(age, name);
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String info() {
		return super.info()+", 부서:"+department;
	}
}

public class InheritSample1 {
	static Person[] pers = new Person[10];
	
	public static void main(String[] args) {
//		Student s = new Student(26,"고길동","수학과");
//		System.out.println(s.info());
//		Person p = new Student(26,"고길동","수학과"); // upcasting : 자식 객체를 부모 타입 변수에 넣을 수 있음
//		Student s2 = (Student)p; // downcasting : 부모 타입의 객체를 자식 타입 변수에 넣음
		
		// 다형성
		// 상속과 오버라이딩을 한 자식 클래스를 생성하여 부모 변수에 넣었을 때,
		// 부모의 변수를 통해 오버라이딩 한 메소드를 호출할 경우 자식 메소드가 호출됨
//		Person p = new Student(20,"고길동","수학");
//		System.out.println(p.info());
		
		pers[0] = new Student(20,"고길동","수학");
		pers[1] = new Student(30,"하길동","컴퓨터공학");
		pers[2] = new Professor(50,"나교수","정보과학부");
		
		for (int i=0; i<3; i++) {
			System.out.println(pers[i].info());
		}
		
		for (int i=0; i<3; i++) {
			if (pers[i] instanceof Student) {
//				System.out.println(pers[i].info());
				Student s = (Student)pers[i];
				System.out.println(s.getMajor());
			}
		}
	}
}
