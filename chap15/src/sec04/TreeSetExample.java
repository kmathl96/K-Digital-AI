package sec04;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// TreeSet : 데이터가 정렬됨
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(10);
		ts.add(5);
		ts.add(7);
		
		for (int n : ts) {
			System.out.println(n);
		}
	}
}