import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;
import exp.AccountException;
import exp.BankExpCode;

public class Bank {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Account> accs = new HashMap<>();
	
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
		if (accs.containsKey(id)) {
			throw new AccountException(BankExpCode.EXIST_ACC);
		}	
		accs.put(id,new Account(id,name,money));
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
		if (accs.containsKey(id)) {
			throw new AccountException(BankExpCode.EXIST_ACC);
		}	
		accs.put(id,new SpecialAccount(id,name,money,grade));
		System.out.println("���:Ư�����°� �����Ǿ����ϴ�.");
	}
	public void accsList() throws AccountException {
		System.out.println("---------------------------");
		System.out.println("1.�Ϲݰ��� | 2.Ư������ | 3.��ü");
		System.out.println("---------------------------");
		System.out.print("����>>");
		int sel= Integer.parseInt(sc.nextLine());
		if (sel==1) {
			System.out.println("--------");
			System.out.println("�Ϲݰ��¸��");
			System.out.println("--------");
			for(Account acc : accs.values()) {
				if (!(acc instanceof SpecialAccount))
					System.out.println(acc.accInfo());
			}
		} else if (sel==2) {
			System.out.println("--------");
			System.out.println("Ư�����¸��");
			System.out.println("--------");
			for(Account acc : accs.values()) {
				if (acc instanceof SpecialAccount)
					System.out.println(acc.accInfo());
			}
		} else if (sel==3){
			System.out.println("--------");
			System.out.println("��ü���¸��");
			System.out.println("--------");
			for(Account acc : accs.values()) {
				System.out.println(acc.accInfo());
			}
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
		if (!accs.containsKey(id)) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		Account acc = accs.get(id);
		acc.deposit(money);
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
		if (!accs.containsKey(id)) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		Account acc = accs.get(id);
		acc.withdraw(money);
		System.out.println("���:����� �����Ͽ����ϴ�.");
	}
	public void accInfo() throws AccountException {
		System.out.println("--------");
		System.out.println("������ȸ");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id=sc.nextLine();
		if (!accs.containsKey(id)) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		Account acc = accs.get(id);
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
	
	public void writeAccs() {
		// ���� ��
		// �� ������ Ư������ ����,���¹�ȣ,�̸�,�ܾ�,(���)
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("accs.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(accs.size()); // ���� ��
			for (Account acc : accs.values()) {
				if (acc instanceof SpecialAccount) {
					dos.writeChar('S'); // Ư������
					dos.writeUTF(((SpecialAccount) acc).getGrade()); // ���
				} else {
					dos.writeChar('N'); // �Ϲݰ���
				}
				dos.writeUTF(acc.getId()); // ���¹�ȣ
				dos.writeUTF(acc.getName()); // �̸�
				dos.writeInt(acc.getBalance()); // �ܾ�
			}
		} catch (IOException e) {
		} finally {
			try {
				if (dos!=null) dos.close();
			} catch (IOException e) {}
		}
	}
	public void readAccs() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		int cnt, balance;
		char sect;
		String id, name, grade=null;
		Account acc;
		try {
			fis = new FileInputStream("accs.dat");
			dis = new DataInputStream(fis);
			cnt = dis.readInt(); // ���� ��
			for (int i=0; i<cnt; i++) {
				sect = dis.readChar(); // ���±���(Ư������/�Ϲݰ���)
				if (sect=='S') grade = dis.readUTF(); // ���
				id = dis.readUTF(); // ���¹�ȣ
				name = dis.readUTF(); // �̸�
				balance = dis.readInt(); // �ܾ�
				if (sect=='S') {
					acc = new SpecialAccount(id,name,balance,grade);
				} else {
					acc = new Account(id,name,balance);
				}
				accs.put(id, acc);
			}
		} catch (IOException e) {
		} finally {
			try {
				if (dis!=null) dis.close();
			} catch (IOException e) {}
		}
	}
	public void writeAccs_t() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("accs.txt");
			bw = new BufferedWriter(fw);
			for (Account acc : accs.values()) {
				String info = "";
				info += acc.getId()+"#"+acc.getName()+"#"+acc.getBalance();
				if (acc instanceof SpecialAccount) {
					info += "#"+((SpecialAccount)acc).getGrade();
				}
				bw.write(info);
				bw.newLine();
				bw.close();
			}
		} catch (IOException e) {
		} finally {
			try {
				if (bw!=null) bw.close();
			} catch (IOException e) {}
		}
	}
	public void readAccs_t() {
		FileReader fr = null;
		BufferedReader br = null;
		String info,id,name,grade;
		int balance;
		try {
			fr = new FileReader("accs.txt");
			br = new BufferedReader(fr);
			while ((info=br.readLine())!=null) {
				String[] its = info.split("#");
				id = its[0];
				name = its[1];
				balance = Integer.parseInt(its[2]);
				if (its.length==4) {
					grade = its[3];
					accs.put(id, new SpecialAccount(id,name,balance,grade));
				} else {
					accs.put(id, new Account(id,name,balance));
				}
			}
		} catch (IOException e) {
		} finally {
			try {
				if (br!=null) br.close();
			} catch (IOException e) {}
		}
	}
	public void writeAccs_s() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("accs.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(accs);
		} catch (IOException e) {
		} finally {
			try {
				if (oos!=null) oos.close();
			} catch (IOException e) {
			}
		}
	}
	public void readAccs_s() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("accs.ser");
			ois = new ObjectInputStream(fis);
			accs = (HashMap<String, Account>)(ois.readObject());
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			try {
				if (ois!=null) ois.close();
			} catch (IOException e) {
			}
		}
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
//		bank.readAccs();
//		bank.readAccs_t();
		bank.readAccs_s();
		int sel;
		while(true) {
			try {
				sel = bank.menu();
				if (sel==0) {
//					bank.writeAccs();
//					bank.writeAccs_t();
					bank.writeAccs_s();
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
