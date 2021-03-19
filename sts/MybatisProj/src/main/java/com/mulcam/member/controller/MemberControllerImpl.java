package com.mulcam.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mulcam.member.service.MemberService;
import com.mulcam.member.vo.MemberVO;

@Controller
public class MemberControllerImpl implements MemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;
	
	@Override
	@RequestMapping(value="/member/listMembers.do")
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView("/member/listMembers"); // 생성할 때 view name 넣을 수 있음
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do")
	public ModelAndView addMember(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/removeMember.do")
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/login.do")
	public ModelAndView login(MemberVO memberVO, RedirectAttributes redirectAttributes, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(memberVO);
		if (memberVO!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/member/listMembers.do");
		} else {
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}

	@Override
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result, // required=false : 꼭 있을 필요는 없음
			                  @RequestParam(value= "action", required=false) String action,
			                  HttpServletRequest request, 
			                  HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action); 
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}

}
