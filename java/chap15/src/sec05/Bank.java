package sec05;

import java.util.HashMap;
import java.util.Scanner;

//import acc.SpecialAccount;

public class Bank {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Account> accs = new HashMap<String, Account>();
	
	public void createAccount() {
		System.out.println("--------");
		System.out.println("일반계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("초기입금액:");
		int money = Integer.parseInt(sc.nextLine());
		
		if (accs.containsKey(id)) {
			System.out.println("이미 존재하는 계좌입니다.");
		} else {
			accs.put(id, new Account(id, name, money));
			System.out.println("일반계좌가 개설되었습니다.");
		}	
	}
	public void createSpecialAccount() {
		System.out.println("--------");
		System.out.println("특수계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("초기입금액:");
		int money = Integer.parseInt(sc.nextLine());	
		System.out.print("등급(VIP:1,Gold:2,Silver:3,Normal:4):");
		int ngrade=Integer.parseInt(sc.nextLine());
		String grade="Normal";
		switch(ngrade) {
		case 1: grade="VIP"; break;
		case 2: grade="Gold"; break;
		case 3: grade="Silver"; break;
		case 4: grade="Normal"; break;
		}

		if (accs.containsKey(id)) {
			System.out.println("이미 존재하는 계좌입니다.");
		} else {
			accs.put(id, new SpecialAccount(id, name, money, grade));
			System.out.println("특수계좌가 개설되었습니다.");
		}
	}
	public void accsList() {
		System.out.println("---------------------------");
		System.out.println("1.일반계좌 | 2.특수계좌 | 3.전체");
		System.out.println("---------------------------");
		System.out.print("선택>>");
		int sel= Integer.parseInt(sc.nextLine());
		if (sel==1) {
			System.out.println("--------");
			System.out.println("계좌목록");
			System.out.println("--------");
			for (Account acc : accs.values()) {
				if (!(acc instanceof SpecialAccount))
					System.out.println(acc.accInfo());
			}
		} else if (sel==2) {
			System.out.println("--------");
			System.out.println("계좌목록");
			System.out.println("--------");
			for (Account acc : accs.values()) {
				if (acc instanceof SpecialAccount)
					System.out.println(acc.accInfo());
			}
		} else if (sel==3){
			System.out.println("--------");
			System.out.println("계좌목록");
			System.out.println("--------");
			for (Account acc : accs.values()) {
				System.out.println(acc.accInfo());
			}
		} else {
			System.out.println("1~3을 입력해 주세요.");
		}
	}
	private Account searchAccById(String id) {
		if (accs.containsKey(id))
			return accs.get(id);
		return null;
	}
	public void deposit() {
		System.out.println("--------");
		System.out.println("입금");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("예금액:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		if (acc==null) {
			System.out.println("계좌가 존재하지 않습니다.");
		} else {
			if (acc.deposit(money)) {
				System.out.println("결과:예금을 성공하였습니다.");
			} else {
				System.out.println("결과:예금을 실패하였습니다.");
			}
		}
	}
	public void withdraw() {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("출금액:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		if (acc==null) {
			System.out.println("계좌가 존재하지 않습니다.");
		} else {
			if (acc.withdraw(money)) {
				System.out.println("결과:출금을 성공하였습니다.");				
			} else {
				System.out.println("결과:출금을 실패하였습니다.");
			}
		}
	}
	public void accInfo() {
		System.out.println("--------");
		System.out.println("계좌조회");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id=sc.nextLine();
		Account acc = searchAccById(id);
		if (acc==null) {
			System.out.println("계좌가 존재하지 않습니다.");
		} else {
			System.out.println(acc.accInfo());
			System.out.println("결과:계좌가 조회되었습니다.");
		}
	}	
	public int menu() {
		while (true) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌조회 | 3.계좌목록 | 4.예금 | 5.출금 | 0.종료");
			System.out.println("------------------------------------------------------");
			System.out.print("선택>>");
			int sel = Integer.parseInt(sc.nextLine());
			if (sel>=0 && sel<=5) {
				return sel;
			} else {
				System.out.println("1~3을 입력해 주세요.");
			}
		}
	}
	public void accMenu() {
		System.out.println("-------------------");
		System.out.println("1.일반계좌 | 2.특수계좌");
		System.out.println("-------------------");
		System.out.print("선택>>");
		int sel= Integer.parseInt(sc.nextLine());
		if(sel==1) {
			createAccount();
		} else if (sel==2){
			createSpecialAccount();
		}
	}
	public static void main(String[] args) {
		Bank bank = new Bank();
		int sel;
		while(true) {
			try {
				sel = bank.menu();
				if (sel==0)
					break;
				switch(sel) {
				case 1: bank.accMenu(); break;
				case 2: bank.accInfo(); break;
				case 3: bank.accsList(); break;
				case 4: bank.deposit(); break;
				case 5: bank.withdraw(); break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력이 가능합니다.");
			}
		}
	}
}
