package com.mulcam.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mulcam.bank.dao.MemberDAO;
import com.mulcam.bank.vo.Member;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void join(Member mem) throws Exception {
		Member m = memberDAO.selectMember(mem.getId());
		if (m!=null) throw new Exception("아이디 중복");
		memberDAO.insertMember(mem);
	}

	@Override
	public boolean login(String id, String password) throws Exception {
		Member mem = memberDAO.selectMember(id);
		if (mem==null) throw new Exception("아이디 오류");
		if (mem.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
