package com.mulcam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class MainController {

	@RequestMapping(value="main1.do", method=RequestMethod.GET) // 8090/test/main1.do
	public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","main1");
		mav.setViewName("/test/main");
		return mav;
	}
	
	@RequestMapping(value="main2.do", method=RequestMethod.GET) // 8090/test/main2.do
	public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","main2");
		mav.setViewName("/test/main");
		return mav;
	}
}
