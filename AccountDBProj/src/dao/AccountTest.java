package dao;

import java.util.List;

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
	public static void queryAllAccounts() {
		AccountDAO dao = new AccountDAO();
		List<Account> list = dao.queryAllAccounts();
		dao.connectClose();
		for (Account acc : list) {
			System.out.println(acc.accInfo());
		}
	}
	public static void queryAccounts() {
		AccountDAO dao = new AccountDAO();
		List<Account> list = dao.queryAccounts();
		dao.connectClose();
		for (Account acc : list) {
			System.out.println(acc.accInfo());
		}
	}
	public static void querySpecialAccounts() {
		AccountDAO dao = new AccountDAO();
		List<SpecialAccount> list = dao.querySpecialAccounts();
		dao.connectClose();
		for (Account acc : list) {
			System.out.println(acc.accInfo());
		}
	}
	public static void depositAccount() {
		AccountDAO dao = new AccountDAO();
		dao.depositAccount("1001", 1000);
		dao.connectClose();
	}
	public static void withdrawAccount() {
		AccountDAO dao = new AccountDAO();
		dao.withdrawAccount("1001",10000);
		dao.connectClose();
	}
	public static void transferAccount() {
		AccountDAO dao = new AccountDAO();
		dao.transferAccount("1001", "1002", 5000);
		dao.connectClose();
	}
	public static void main(String[] args) {
//		insertAccount();
//		queryAccount();
//		depositAccount();
//		withdrawAccount();
//		queryAllAccounts();
//		queryAccounts();
//		querySpecialAccounts();
		transferAccount();
	}
}