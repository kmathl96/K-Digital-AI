package chap6;

import chap6.pac.Person; // �ٸ� ��Ű���� Ŭ������ ���� ����

public class Person_ex {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.info());
		
		Person p1 = new Person();
		p1.setAge(26);
		p1.setName("java");
		System.out.println(p1.info());
		System.out.println(p1.getAge());
		
		Person p2 = new Person();
		p2.setAge(25);
		p2.setName("python");
		System.out.println(p2.info());
		
		Person p3 = new Person("c", 20);
		System.out.println(p3.info());
		
		Person p4 = new Person("django");
		System.out.println(p4.info());
		
		Person p5 = new Person(26);
		System.out.println(p5.info());
		
//		Person p6 = new Person(26, "spring"); // error
	}
}