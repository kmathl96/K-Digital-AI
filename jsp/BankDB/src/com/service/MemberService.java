package com.service;

import java.sql.Connection;

import com.bean.Member;
import com.dao.MemberDAO;
import com.db.JdbcUtil;

public class MemberService {
	public void makeMember(Member mem) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO();
		try {
			if (dao.queryMember(mem.getId(), conn)!=null) {
				throw new Exception();
			}
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
}