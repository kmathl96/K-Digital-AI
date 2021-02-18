package dao;

import dto.Account;
import dto.SpecialAccount;

public class AccountTest {
	public static void insertAccount() {
		AccountDAO dao = new AccountDAO();
		dao.insertAccount(new Account("1001","hong",100000));
		dao.insertAccount(new SpecialAccount("1002","park",200000,"VIP"));
		dao.connectClose();
	}
	public static void queryAccount() {
		AccountDAO dao = new AccountDAO();
		Account acc = dao.queryAccount("1001");
		dao.connectClose();
		System.out.println(acc.accInfo());
	}
	public static void depositAccount() {
		AccountDAO dao = new AccountDAO();
		dao.depositAccount("1001", 1000);
	}
	public static void main(String[] args) {
//		insertAccount();
//		queryAccount();
		depositAccount();
	}
}