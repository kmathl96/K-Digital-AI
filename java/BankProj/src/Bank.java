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
		System.out.println("�Ϲݰ��»���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�ʱ��Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		
		AccountDAO dao = new AccountDAO();
		Account acc = dao.queryAccount(id);
		
		if (acc!=null) { // �ߺ� ���� üũ
			throw new AccountException(BankExpCode.EXIST_ACC);
		}
		dao.insertAccount(new Account(id, name, money));
		dao.connectClose();
		System.out.println("���:�Ϲݰ��°� �����Ǿ����ϴ�.");
	}
	public void createSpecialAccount() throws AccountException {
		System.out.println("--------");
		System.out.println("Ư�����»���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�ʱ��Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());	
		System.out.print("���(VIP:1,Gold:2,Silver:3,Normal:4):");
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
		System.out.println("���:Ư�����°� �����Ǿ����ϴ�.");
	}
	public void accsList() throws AccountException {
		System.out.println("---------------------------");
		System.out.println("1.�Ϲݰ��� | 2.Ư������ | 3.��ü");
		System.out.println("---------------------------");
		System.out.print("����>>");
		int sel= Integer.parseInt(sc.nextLine());
		AccountDAO dao = new AccountDAO();
		if (sel==1) {
			System.out.println("--------");
			System.out.println("�Ϲݰ��¸��");
			System.out.println("--------");
			ArrayList<Account> lst = dao.queryAccounts();
			for (Account acc : lst) {
				System.out.println(acc.accInfo());
			}
			dao.connectClose();
		} else if (sel==2) {
			System.out.println("--------");
			System.out.println("Ư�����¸��");
			System.out.println("--------");
			ArrayList<SpecialAccount> lst = dao.querySpecialAccounts();
			for (Account acc : lst) {
				System.out.println(acc.accInfo());
			}
			dao.connectClose();
		} else if (sel==3){
			System.out.println("--------");
			System.out.println("��ü���¸��");
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
		System.out.println("�Ա�");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("���ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		AccountDAO dao = new AccountDAO();
		dao.depositAccount(id, money);
		dao.connectClose();
		System.out.println("���:������ �����Ͽ����ϴ�.");
	}
	public void withdraw() throws AccountException {
		System.out.println("--------");
		System.out.println("���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("��ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		AccountDAO dao = new AccountDAO();
		dao.withdrawAccount(id, money);
		dao.connectClose();
		System.out.println("���:����� �����Ͽ����ϴ�.");
	}
	public void accInfo() throws AccountException {
		System.out.println("--------");
		System.out.println("������ȸ");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id=sc.nextLine();
		
		AccountDAO dao = new AccountDAO();
		Account acc = dao.queryAccount(id);
		if (acc==null) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		dao.connectClose();
		System.out.println(acc.accInfo());
		System.out.println("���:���°� ��ȸ�Ǿ����ϴ�.");
	}	
	public int menu() throws AccountException {
		System.out.println("------------------------------------------------------");
		System.out.println("1.���»��� | 2.������ȸ | 3.���¸�� | 4.���� | 5.��� | 0.����");
		System.out.println("------------------------------------------------------");
		System.out.print("����>>");
		int sel = Integer.parseInt(sc.nextLine());
		if (sel>=0 && sel<=5) return sel;
		throw new AccountException(BankExpCode.MAIN_MENU);
	}
	public void accMenu() throws AccountException {
		System.out.println("-------------------");
		System.out.println("1.�Ϲݰ��� | 2.Ư������");
		System.out.println("-------------------");
		System.out.print("����>>");
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
				System.out.println("���ڸ� �Է��� �����մϴ�.");
			} catch (AccountException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
