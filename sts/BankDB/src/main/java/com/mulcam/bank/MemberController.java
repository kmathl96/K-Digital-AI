package com.mulcam.bank;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.beans.Member;
import com.mulcam.bank.dao.MemberDAO;

@Controller
public class MemberController {
	private MemberDAO memberDao;
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("page", "join_form");
		return "template";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView join(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Member mem = null;
		try {
			mem = memberDao.queryMember(mem.getId());
			modelAndView.addObject("err","중복되는 아이디");
			modelAndView.addObject("page","err");
		} catch (Exception e) {
			mem = new Member();
			mem.setId(request.getParameter("id"));
			mem.setPassword(request.getParameter("password"));
			mem.setName(request.getParameter("name"));
			mem.setSex(request.getParameter("sex"));
			mem.setAge(Integer.parseInt(request.getParameter("age")));
			mem.setEmail(request.getParameter("email"));
			try {
				memberDao.insertMember(mem);
				modelAndView.addObject("page","login_form");
			} catch (Exception e2) {
				modelAndView.addObject("err","회원가입 오류");
				modelAndView.addObject("page","err");
			}
		}
		// 결과와 페이지를 한번에 넣어서 반환
		modelAndView.setViewName("template");
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("page","login_form");
		return "template";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			Member mem = memberDao.queryMember(id);
			if (mem.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				modelAndView.addObject("page", "makeaccount_form");
			} else throw new Exception();
		} catch (Exception e) {
			modelAndView.addObject("page", "login_form");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		model.addAttribute("page", "login_form");
		return "template";
	}
}