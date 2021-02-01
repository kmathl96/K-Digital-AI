package acc;

import exp.AccountException;
import exp.BankExpCode;

public class Account {
	String id;
	String name;
	int balance;
	
	public Account() {}
	public Account(String id, String name, int money) {
		this.id=id;
		this.name=name;
		this.balance=money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public boolean deposit(int money) throws AccountException {
		if(money<=0)
			throw new AccountException(BankExpCode.DEPOSIT);
		balance+=money;
		return true;
	}
	public boolean withdraw(int money) throws AccountException {
		if (balance<money)
			throw new AccountException(BankExpCode.WITHDRAW);
		balance-=money;
		return true;
	}	
	public String accInfo() {
		return "°èÁÂ¹øÈ£:"+id+", ÀÌ¸§:"+name+", ÀÜ¾×:"+balance;
	}
}