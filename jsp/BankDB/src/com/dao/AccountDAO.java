package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Account;
import com.db.JdbcUtil;
import com.err.AccountException;
import com.err.BankErrCode;

public class AccountDAO {
	public void insertAccount(Account acc, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "insert into accountw values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getSect());
			pstmt.setString(5, acc.getGrade());
			
			int count = pstmt.executeUpdate();
			if (count!=1) {
				throw new AccountException(BankErrCode.FAIL_MAKE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	public Account queryAccount(String id, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from accountw where id=?";
		Account acc = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				acc = new Account();
				acc.setId(rset.getString(1));
				acc.setName(rset.getString(2));
				acc.setBalance(rset.getInt(3));
				acc.setSect(rset.getString(4));
				acc.setGrade(rset.getString(5));
			} else {
				throw new AccountException(BankErrCode.NOT_ACC);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}
		return acc;
	}
	public void updateAccBalance(String id, int money, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "update accountw set balance=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, id);
			int count = pstmt.executeUpdate();
			if (count != 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	public ArrayList<Account> queryAccounts(Connection conn) throws Exception {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = "select * from accountw";
		ArrayList<Account> accs = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Account acc = new Account();
				acc.setId(rset.getString(1));
				acc.setName(rset.getString(2));
				acc.setBalance(rset.getInt(3));
				acc.setSect(rset.getString(4));
				acc.setGrade(rset.getString(5));
				accs.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(stmt);
		}
		return accs;
	}
}