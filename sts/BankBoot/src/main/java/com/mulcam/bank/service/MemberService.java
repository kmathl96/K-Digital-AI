package com.mulcam.bank.service;

import com.mulcam.bank.vo.Member;

public interface MemberService {
	public void join(Member mem) throws Exception;
	public boolean login(String id, String password) throws Exception;
}
