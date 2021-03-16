package com.mulcam.homework4;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
   @ResponseBody
   @RequestMapping("/ajax")
   public String login(HttpServletRequest request) {
	   String id = request.getParameter("id");
       return id+"님 login ok";
   }
   
   @RequestMapping("/")
   public String hello(Model model){
       System.out.println("hello");
       model.addAttribute("message","주목받는 AI 9대 핵심 기술 분석");
       return "test1";
   }
}