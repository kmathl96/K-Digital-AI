package sec03;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<String> hset = new HashSet<String>();
		hset.add("hong");
		hset.add("gil");
		hset.add("dong");
		
		for (String name : hset) {
			System.out.println(name);
		}
		
		Iterator<String> iterator = hset.iterator();
		while (iterator.hasNext()) { // 다음 데이터 있으면
			System.out.println(iterator.next());
		}
		hset.clear();
	}
}