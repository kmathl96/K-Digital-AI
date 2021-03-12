package com.mulcam.bank.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.mulcam.bank.bean.Member;

public class MemberDAOImpl implements MemberDAO {
	private SqlSessionTemplate sqlSession;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertMember(Member mem) throws Exception {
		sqlSession.insert("mapper.member.insertMember", mem);
	}
	
	@Override
	public Member queryMember(String id) throws Exception {
		return sqlSession.selectOne("mapper.member.selectMember", id);
	}
}