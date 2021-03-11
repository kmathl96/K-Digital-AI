package com.mulcam.bank.dao;

import com.mulcam.bank.beans.Member;

public interface MemberDAO {
	public void insertMember(Member mem) throws Exception;
	public Member queryMember(String id) throws Exception;
}