package com.mulcam.clova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View {
	@RequestMapping(value="/")
	public String test() {
		return "pizzaorder";
	}

}
