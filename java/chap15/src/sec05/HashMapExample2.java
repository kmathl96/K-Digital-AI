package sec05;

import java.util.HashMap;

public class HashMapExample2 {

	public static void main(String[] args) {
		HashMap<String, Account> accs = new HashMap<String, Account>();
//		TreeMap<String, Account> accs = new TreeMap<String, Account>(); // 정렬 됨
		accs.put("1001", new Account("1001","홍길동",10000));
		accs.put("1002", new Account("1002","고길동",20000));
		accs.put("1003", new Account("1003","장길동",30000));
		
		// 계좌 조회
		System.out.println(accs.get("1003").accInfo());
		
		// 전체 계좌 조회
		for (Account acc : accs.values()) {
			System.out.println(acc.accInfo());
		}
		
		accs.remove("1003");
		if (accs.containsKey("1003")) {
			System.out.println(accs.get("1003"));
		} else {
			System.out.println("없음");
		}
	}
}