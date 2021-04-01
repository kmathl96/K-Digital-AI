package com.mulcam.clova.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
	@RequestMapping(value="/json5", method=RequestMethod.GET)
	public String json5() {
		return "json5";
	}
	
	@RequestMapping(value="/json", method=RequestMethod.POST)
	@ResponseBody
	public void getJson(@RequestParam("jsonInfo") String jsonInfo) {
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
			System.out.println("* 회원 정보 *");
			System.out.println(jsonObject.get("name"));
			System.out.println(jsonObject.get("age"));
			System.out.println(jsonObject.get("gender"));
			System.out.println(jsonObject.get("nickname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/json6", method=RequestMethod.GET)
	public String json6() {
		return "json6";
	}
	
	@RequestMapping(value="/json2", method=RequestMethod.POST)
	@ResponseBody
	public String getJson2() {
		JSONArray memArray = new JSONArray();
		
		JSONObject member = new JSONObject();
		member.put("name", "박지성");
		member.put("age", 25);
		member.put("gender", "남자");
		member.put("nickname", "날센돌이");
		memArray.add(member);
		
		member = new JSONObject();
		member.put("name", "김연아");
		member.put("age", 21);
		member.put("gender", "여자");
		member.put("nickname", "퀸");
		memArray.add(member);
		
		JSONObject totJson = new JSONObject();
		totJson.put("members", memArray);
		
		return totJson.toJSONString();
	}

	@RequestMapping(value="/json7", method=RequestMethod.GET)
	public String json7() {
		return "json7";
	}
	
	@RequestMapping(value="/json3", method=RequestMethod.POST)
	@ResponseBody
	public String getJson3() {
		// member array
		JSONArray memArray = new JSONArray();
		JSONObject member = new JSONObject();
		member.put("name", "박지성");
		member.put("age", 25);
		member.put("gender", "남자");
		member.put("nickname", "날센돌이");
		memArray.add(member);
		
		member = new JSONObject();
		member.put("name", "김연아");
		member.put("age", 21);
		member.put("gender", "여자");
		member.put("nickname", "퀸");
		memArray.add(member);
		
		// book array
		JSONArray bookArray = new JSONArray();
		JSONObject book = new JSONObject();
		book.put("title", "알고리즘 문제 해결 전략");
		book.put("writer", "구종만");
		book.put("price", 50000);
		book.put("genre", "인사이트");
		bookArray.add(book);
		
		book = new JSONObject();
		book.put("title", "뇌를 자극하는 파이썬");
		book.put("writer", "박상현");
		book.put("price", 25000);
		book.put("genre", "한빛미디어");
		bookArray.add(book);
		
		JSONObject totJson = new JSONObject();
		totJson.put("members", memArray);
		totJson.put("books", bookArray);
		
		return totJson.toJSONString();
	}
}
