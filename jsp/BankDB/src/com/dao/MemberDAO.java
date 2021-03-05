package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Account;
import com.bean.Member;
import com.db.JdbcUtil;
import com.err.AccountException;
import com.err.BankErrCode;

public class MemberDAO {
	public void insertMember(Member mem, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "insert into memberw values (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getSex());
			pstmt.setInt(5, mem.getAge());
			pstmt.setString(6, mem.getEmail());
			
			int count = pstmt.executeUpdate();
			if (count!=1) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	public Member queryMember(String id, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from memberw where id=?";
		Member mem = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				mem = new Member();
				mem.setId(rset.getString(1));
				mem.setPassword(rset.getString(2));
				mem.setName(rset.getString(3));
				mem.setSex(rset.getString(4));
				mem.setAge(rset.getInt(5));
				mem.setEmail(rset.getString(6));
			} else {
				throw new AccountException(BankErrCode.NOT_ACC);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}
		return mem;
	}
}