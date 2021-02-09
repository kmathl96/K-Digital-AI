package sec02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	int num;
	String name;
	int age;
	double height;
	double weight;
	Person() {}
	Person(int num, String name, int age, double height, double weight) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "번호:"+num+", 이름:"+name+", 나이:"+age+", 키:"+height+", 몸무게:"+weight;
	}
}

public class ObjectStreamTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Person p1 = new Person(100,"nwh",31,175.7,63.8);
//		Person p2 = new Person(101,"kms",30,180.3,67.2);
//		
//		FileOutputStream fos = new FileOutputStream("person.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(p1);
//		oos.writeObject(p2);
//		oos.close();
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("person.ser");
			ois = new ObjectInputStream(fis);
			Person p1 = (Person)ois.readObject();
			Person p2 = (Person)ois.readObject();
			ois.close();
			System.out.println(p1);
			System.out.println(p2);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (ois!=null) ois.close();
			} catch (IOException e) {}
		}
	}
}