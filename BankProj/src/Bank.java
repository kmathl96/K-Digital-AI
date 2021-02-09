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
		System.out.println("일반계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("초기입금액:");
		int money = Integer.parseInt(sc.nextLine());
		if (accs.containsKey(id)) {
			throw new AccountException(BankExpCode.EXIST_ACC);
		}	
		accs.put(id,new Account(id,name,money));
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
		if (accs.containsKey(id)) {
			throw new AccountException(BankExpCode.EXIST_ACC);
		}	
		accs.put(id,new SpecialAccount(id,name,money,grade));
		System.out.println("결과:특수계좌가 개설되었습니다.");
	}
	public void accsList() throws AccountException {
		System.out.println("---------------------------");
		System.out.println("1.일반계좌 | 2.특수계좌 | 3.전체");
		System.out.println("---------------------------");
		System.out.print("선택>>");
		int sel= Integer.parseInt(sc.nextLine());
		if (sel==1) {
			System.out.println("--------");
			System.out.println("일반계좌목록");
			System.out.println("--------");
			for(Account acc : accs.values()) {
				if (!(acc instanceof SpecialAccount))
					System.out.println(acc.accInfo());
			}
		} else if (sel==2) {
			System.out.println("--------");
			System.out.println("특수계좌목록");
			System.out.println("--------");
			for(Account acc : accs.values()) {
				if (acc instanceof SpecialAccount)
					System.out.println(acc.accInfo());
			}
		} else if (sel==3){
			System.out.println("--------");
			System.out.println("전체계좌목록");
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
		System.out.println("입금");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("예금액:");
		int money = Integer.parseInt(sc.nextLine());
		if (!accs.containsKey(id)) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		Account acc = accs.get(id);
		acc.deposit(money);
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
		if (!accs.containsKey(id)) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		Account acc = accs.get(id);
		acc.withdraw(money);
		System.out.println("결과:출금을 성공하였습니다.");
	}
	public void accInfo() throws AccountException {
		System.out.println("--------");
		System.out.println("계좌조회");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id=sc.nextLine();
		if (!accs.containsKey(id)) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		Account acc = accs.get(id);
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
	
	public void writeAccs() {
		// 계좌 수
		// 각 계좌의 특수계좌 여부,계좌번호,이름,잔액,(등급)
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("accs.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(accs.size()); // 계좌 수
			for (Account acc : accs.values()) {
				if (acc instanceof SpecialAccount) {
					dos.writeChar('S'); // 특수계좌
					dos.writeUTF(((SpecialAccount) acc).getGrade()); // 등급
				} else {
					dos.writeChar('N'); // 일반계좌
				}
				dos.writeUTF(acc.getId()); // 계좌번호
				dos.writeUTF(acc.getName()); // 이름
				dos.writeInt(acc.getBalance()); // 잔액
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
			cnt = dis.readInt(); // 계좌 수
			for (int i=0; i<cnt; i++) {
				sect = dis.readChar(); // 계좌구분(특수계좌/일반계좌)
				if (sect=='S') grade = dis.readUTF(); // 등급
				id = dis.readUTF(); // 계좌번호
				name = dis.readUTF(); // 이름
				balance = dis.readInt(); // 잔액
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
				System.out.println("숫자만 입력이 가능합니다.");
			} catch (AccountException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
