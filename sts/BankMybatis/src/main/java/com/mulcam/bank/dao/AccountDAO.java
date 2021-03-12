package com.mulcam.bank.dao;

import java.util.List;

import com.mulcam.bank.bean.Account;

public interface AccountDAO {
	public void insertAccount(Account acc) throws Exception;
	public Account queryAccount(String id) throws Exception;
	public void updateAccBalance(Account acc) throws Exception;
	public List<Account> queryAccounts() throws Exception;
}
