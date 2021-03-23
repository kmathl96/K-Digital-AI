package com.mulcam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.vo.LoginVO;

@Controller
public class LoginController {
	@RequestMapping(value={"/test/loginForm.do", "test/loginForm2.do"}, method=RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/test/loginForm");
		return mav;
	}
	
	@RequestMapping(value="test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", request.getParameter("userID"));
		mav.addObject("userName", request.getParameter("userName"));
		mav.setViewName("/test/result");
		return mav;
	}
	
	@RequestMapping(value="/test/login2.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login2(@RequestParam("userID") String userID, // request.getParameter 대신 이렇게 쓸 수 있음
							@RequestParam("userName") String userName) {
		ModelAndView mav = new ModelAndView("/test/result");
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		return mav;
	}

	@RequestMapping(value="/test/login3.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login3(@RequestParam(value="userID", required=true) String userID, // request.getParameter 대신 이렇게 쓸 수 있음
							@RequestParam(value="userName", required=true) String userName,
							@RequestParam(value="email", required=false) String email) {
		ModelAndView mav = new ModelAndView("/test/result");
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		return mav;
	}
	
	@RequestMapping(value="/test/login4.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login4(@RequestParam Map<String,String> info) {
		ModelAndView mav = new ModelAndView("/test/result");
		mav.addObject("userID", info.get("userID"));
		mav.addObject("userName", info.get("userName"));
		return mav;
	}
	
	@RequestMapping(value="/test/login5.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login5(@ModelAttribute("info") LoginVO loginVO) { // ModelAttribute는 리턴되는 페이지로 자동으로 데이터를 넘겨줌
		ModelAndView mav = new ModelAndView("/test/result");
//		mav.addObject("userID", loginVO.getUserID());
//		mav.addObject("userName", loginVO.getUserName());
		return mav;
	}
	
	@RequestMapping(value="/test/login6.do", method={RequestMethod.GET, RequestMethod.POST})
	String login5(Model model, HttpServletRequest request) {
		model.addAttribute("userID", request.getParameter("userID"));
		model.addAttribute("userName", request.getParameter("userName"));
		return "/test/result";
	}
}
