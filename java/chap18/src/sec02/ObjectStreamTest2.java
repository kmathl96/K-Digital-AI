package sec02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamTest2 {

	public static void main(String[] args) {
//		List<Person> al = new ArrayList<>();
//		al.add(new Person(100,"nwh",31,175.7,63.8));
//		al.add(new Person(101,"kms",30,180.3,67.2));
//		
//		FileOutputStream fos = null;
//		ObjectOutputStream oos = null;
//		try {
//			fos = new FileOutputStream("person2.ser");
//			oos = new ObjectOutputStream(fos);
//			oos.writeObject(al);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				oos.close();
//			} catch (IOException e) {
//				System.out.println(e.getMessage());
//			} catch (Exception e2) {
//				System.out.println(e2.getMessage());
//			}
//		}
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Person> list;
		try {
			fis = new FileInputStream("person2.ser");
			ois = new ObjectInputStream(fis);
			list = (ArrayList<Person>)(ois.readObject());
			for (Person p : list) {
				System.out.println(p);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
			}
		}
	}
}