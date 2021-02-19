import java.util.ArrayList;
import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;
import dao.AccountDAO;
import exp.AccountException;
import exp.BankExpCode;

public class Bank {
	Scanner sc = new Scanner(System.in);
	
	public void createAccount() throws AccountException {
		System.out.println("--------");
		System.out.println("일반계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("초기입금액:");
		int money = Integer.parseInt(sc.nextLine());
		
		AccountDAO dao = new AccountDAO();
		Account acc = dao.queryAccount(id);
		
		if (acc!=null) { // 중복 계좌 체크
			throw new AccountException(BankExpCode.EXIST_ACC);
		}
		dao.insertAccount(new Account(id, name, money));
		dao.connectClose();
		System.out.println("결과:일반계좌가 개설되었습니다.");
	}
	public void createSpecialAccount() throws AccountException {
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
		
		AccountDAO dao = new AccountDAO();
		Account acc = dao.queryAccount(id);
		if (acc!=null) {
			throw new AccountException(BankExpCode.EXIST_ACC);
		}
		dao.insertAccount(new SpecialAccount(id,name,money,grade));
		dao.connectClose();
		System.out.println("결과:특수계좌가 개설되었습니다.");
	}
	public void accsList() throws AccountException {
		System.out.println("---------------------------");
		System.out.println("1.일반계좌 | 2.특수계좌 | 3.전체");
		System.out.println("---------------------------");
		System.out.print("선택>>");
		int sel= Integer.parseInt(sc.nextLine());
		AccountDAO dao = new AccountDAO();
		if (sel==1) {
			System.out.println("--------");
			System.out.println("일반계좌목록");
			System.out.println("--------");
			ArrayList<Account> lst = dao.queryAccounts();
			for (Account acc : lst) {
				System.out.println(acc.accInfo());
			}
			dao.connectClose();
		} else if (sel==2) {
			System.out.println("--------");
			System.out.println("특수계좌목록");
			System.out.println("--------");
			ArrayList<SpecialAccount> lst = dao.querySpecialAccounts();
			for (Account acc : lst) {
				System.out.println(acc.accInfo());
			}
			dao.connectClose();
		} else if (sel==3){
			System.out.println("--------");
			System.out.println("전체계좌목록");
			System.out.println("--------");
			ArrayList<Account> lst = dao.queryAllAccounts();
			for (Account acc : lst) {
				System.out.println(acc.accInfo());
			}
			dao.connectClose();
		} else {
			throw new AccountException(BankExpCode.LIST_MENU);
		}
	}
	
	public void deposit() throws AccountException {
		System.out.println("--------");
		System.out.println("입금");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("예금액:");
		int money = Integer.parseInt(sc.nextLine());
		AccountDAO dao = new AccountDAO();
		dao.depositAccount(id, money);
		dao.connectClose();
		System.out.println("결과:예금을 성공하였습니다.");
	}
	public void withdraw() throws AccountException {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("출금액:");
		int money = Integer.parseInt(sc.nextLine());
		AccountDAO dao = new AccountDAO();
		dao.withdrawAccount(id, money);
		dao.connectClose();
		System.out.println("결과:출금을 성공하였습니다.");
	}
	public void accInfo() throws AccountException {
		System.out.println("--------");
		System.out.println("계좌조회");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id=sc.nextLine();
		
		AccountDAO dao = new AccountDAO();
		Account acc = dao.queryAccount(id);
		if (acc==null) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		dao.connectClose();
		System.out.println(acc.accInfo());
		System.out.println("결과:계좌가 조회되었습니다.");
	}	
	public int menu() throws AccountException {
		System.out.println("------------------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌조회 | 3.계좌목록 | 4.예금 | 5.출금 | 0.종료");
		System.out.println("------------------------------------------------------");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		if (sel>=0 && sel<=5) return sel;
		throw new AccountException(BankExpCode.MAIN_MENU);
	}
	public void accMenu() throws AccountException {
		System.out.println("-------------------");
		System.out.println("1.일반계좌 | 2.특수계좌");
		System.out.println("-------------------");
		System.out.print("선택>>");
		int sel= Integer.parseInt(sc.nextLine());
		if(sel==1) {
			createAccount();
		} else if (sel==2){
			createSpecialAccount();
		} else {
			throw new AccountException(BankExpCode.ACC_MENU);
		}
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		int sel;
		while(true) {
			try {
				sel = bank.menu();
				if (sel==0) {
					break;
				}
				switch(sel) {
				case 1: bank.accMenu(); break;
				case 2: bank.accInfo(); break;
				case 3: bank.accsList(); break;
				case 4: bank.deposit(); break;
				case 5: bank.withdraw(); break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력이 가능합니다.");
			} catch (AccountException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
