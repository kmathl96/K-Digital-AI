package sec02;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(); // 제너릭
		list.add("hong");
		list.add("gil");
		list.add("dong");
//		for (int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		for (String name : list) {
			System.out.println(name);
		}
		
		list.remove(0); // 자동으로 당겨짐
		for (String name : list) {
			System.out.println(name);
		}
		
		list.remove("gil");
		for (String name : list) {
			System.out.println(name);
		}
	}
}