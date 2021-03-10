package com.mulcam.bank;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("page","login_form");
		return "template";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String id = request.getParameter("id");
			if (id==null || id.equals("")) {
				throw new Exception();
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				modelAndView.addObject("page", "makeaccount_form");
			}
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