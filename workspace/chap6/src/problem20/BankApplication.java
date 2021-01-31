package problem20;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static  Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("------------------------------------------");
			System.out.print("����> ");
			
			// 1~5�� �ƴ� ���ڳ� �ٸ� ���ڿ��� ������ ��츦 ó���ϱ� ���� nextLine()���� �Է� ����
			String selectNo = scanner.nextLine();
			
			if (selectNo.equals("1")) {
				createAccount();
			} else if (selectNo.equals("2")) {
				accountList();
			} else if (selectNo.equals("3")) {
				deposit();
			} else if (selectNo.equals("4")) {
				withdraw();
			} else if (selectNo.equals("5")) {
				run = false;
			} else { // 1~5�� �ƴ� ���ڿ��� ���
				System.out.println("�ٽ� �Է��� �ּ���.");
			}
			
//			// switch������ ó���ϴ� ���
//			switch(selectNo) {
//			case 1: createAccount(); break;
//			case 2: accountList(); break;
//			case 3: deposit(); break;
//			case 4: withdraw(); break;
//			case 5: run = false; break;
//			default: System.out.println("�ٽ� �Է��� �ּ���.");
//			}
		}
		System.out.println("���α׷� ����");
	}
	
	// ���� �����ϱ�
	private static void createAccount() {
		System.out.println("------");
		System.out.println("���»���");
		System.out.println("------");

		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("������: ");
		String owner = scanner.next();
		System.out.print("�ʱ��Աݾ�: ");
		int balance = scanner.nextInt();
		
		accountArray[Account.num] = new Account(ano, owner, balance);
		Account.num++;
		System.out.println("���: ���°� �����Ǿ����ϴ�.");
	}
	
	// ���� ��� ����
	private static void accountList() {
		System.out.println("------");
		System.out.println("���¸��");
		System.out.println("------");
		for (int i=0; i<Account.num; i++) {
			System.out.println(accountArray[i].getAno()+'\t'+accountArray[i].getOwner()+'\t'+accountArray[i].getBalance());
		}
	}
	
	// �����ϱ�
	private static void deposit() {
		System.out.println("------");
		System.out.println("����");
		System.out.println("------");

		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("���ݾ�: ");
		int amount = scanner.nextInt();
		
		if (findAccount(ano) != null) {
			int balance = findAccount(ano).getBalance();
			findAccount(ano).setBalance(balance+amount);
			System.out.println("���: ������ �����Ǿ����ϴ�.");
		} else {
			System.out.println("�ش� ���´� �������� �ʽ��ϴ�.");
		}
	}
	
	// ����ϱ�
	private static void withdraw() {
		System.out.println("------");
		System.out.println("���");
		System.out.println("------");

		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("��ݾ�: ");
		int amount = scanner.nextInt();
		
		if (findAccount(ano) != null) {
			int balance = findAccount(ano).getBalance();
			if (balance >= amount) {
				findAccount(ano).setBalance(balance-amount);
				System.out.println("���: ����� �����Ǿ����ϴ�.");			
			} else {
				System.out.println("���: ����� ���еǾ����ϴ�.");			
			}
		} else {
			System.out.println("�ش� ���´� �������� �ʽ��ϴ�.");
		}
	}
	
	// Account �迭���� ano�� ������ Account ��ü ã��
	private static Account findAccount(String ano) {
		Account ac = null;
		for (int i=0; i<Account.num; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				ac = accountArray[i];
			}
		}
		return ac;
	}
}