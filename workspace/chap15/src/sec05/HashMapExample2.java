package sec05;

import java.util.HashMap;

public class HashMapExample2 {

	public static void main(String[] args) {
		HashMap<String, Account> accs = new HashMap<String, Account>();
//		TreeMap<String, Account> accs = new TreeMap<String, Account>(); // ���� ��
		accs.put("1001", new Account("1001","ȫ�浿",10000));
		accs.put("1002", new Account("1002","��浿",20000));
		accs.put("1003", new Account("1003","��浿",30000));
		
		// ���� ��ȸ
		System.out.println(accs.get("1003").accInfo());
		
		// ��ü ���� ��ȸ
		for (Account acc : accs.values()) {
			System.out.println(acc.accInfo());
		}
		
		accs.remove("1003");
		if (accs.containsKey("1003")) {
			System.out.println(accs.get("1003"));
		} else {
			System.out.println("����");
		}
	}
}