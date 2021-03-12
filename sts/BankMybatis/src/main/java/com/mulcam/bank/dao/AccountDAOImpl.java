package com.mulcam.bank.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.mulcam.bank.bean.Account;

public class AccountDAOImpl implements AccountDAO {
	private SqlSessionTemplate sqlSession;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public void insertAccount(Account acc) throws Exception {
		sqlSession.insert("mapper.account.insertAccount", acc);
	}

	@Override
	public Account queryAccount(String id) throws Exception {		
		return sqlSession.selectOne("mapper.account.selectAccount", id);
	}

	@Override
	public void updateAccBalance(Account acc) throws Exception {
		sqlSession.update("mapper.account.updateAccount", acc);
	}

	@Override
	public List<Account> queryAccounts() throws Exception {
		return sqlSession.selectList("mapper.account.selectAllAccountList");
	}

}
