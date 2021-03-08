package com.service;

import java.sql.Connection;

import com.bean.Member;
import com.dao.MemberDAO;
import com.db.JdbcUtil;

public class MemberService {
	public void joinMember(Member mem) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO();
		try {
//			if (dao.queryMember(mem.getId(), conn)!=null) {
//				throw new Exception();
//			}
			dao.insertMember(mem, conn);
			JdbcUtil.commit(conn);
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	public boolean loginMember(String id, String password) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO();
		boolean success = false;
		try {
			Member mem = dao.queryMember(id, conn);
			if (mem==null) throw new Exception("아이디 오류");
			if (mem.getPassword().equals(password)) {
				success = true;
			} else {
				throw new Exception("패스워드 오류");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		return success;
	}
}