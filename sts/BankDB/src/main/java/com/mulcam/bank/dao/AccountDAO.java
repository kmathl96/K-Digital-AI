package com.mulcam.bank.dao;

import java.util.List;

import com.mulcam.bank.beans.Account;

public interface AccountDAO {
	public void insertAccount(Account acc) throws Exception;
	public Account queryAccount(String id) throws Exception;
	public void updateAccBalance(String id, int money) throws Exception;
	public List<Account> queryAccounts() throws Exception;
}
