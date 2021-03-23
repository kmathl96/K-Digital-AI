package com.mulcam.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//spring3에서는 @Controller + @ResponseBody
@RestController // 컨트롤러가 브라우저로 view(.jsp)가 아닌 데이터 자체(기본형 텍스트, 객체, Map)를 전송
@RequestMapping("/test/*")
public class TestController {
	// 로그 남기는 방법
	static Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST!";
	}
	
	@RequestMapping("/member")
	public MemberVO member() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPwd("1234");
		vo.setName("홍길동");
		vo.setEmail("hong@test.com");
		return vo;
	}
	
	@RequestMapping("/memberList")
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i=0; i<10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong"+i);
			vo.setPwd("123"+i);
			vo.setName("홍길동"+i);
			vo.setEmail("hong"+i+"@test.com");
			list.add(vo);
		}
		return list;
	}
	
	@RequestMapping("/memberMap")
	public Map<Integer, MemberVO> memberMap() {
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		for (int i=0; i<10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong"+i);
			vo.setPwd("123"+i);
			vo.setName("홍길동"+i);
			vo.setEmail("hong"+i+"@test.com");
			map.put(i,vo);
		}
		return map;
	}
	
	@RequestMapping(value="/notice/{num}", method=RequestMethod.GET)
	public int notice(@PathVariable("num") int num) { // @PathVariable : 브라우저에서 요청 URL로 전달된 매개변수를 가져옴
		return num;
	}
	
	@RequestMapping(value="/info", method=RequestMethod.POST)
	public void modify(@RequestBody MemberVO vo) { // @RequestBody : 브라우저에서 전달되는 json 데이터를 객체(MemberVO)로 자동 변환
		logger.info(vo.toString());
	}
	
	@RequestMapping("/memberList2")
	public ResponseEntity<List<MemberVO>> listMembers2() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i=0; i<10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong"+i);
			vo.setPwd("123"+i);
			vo.setName("홍길동"+i);
			vo.setEmail("hong"+i+"@test.com");
			list.add(vo);
		}
		return new ResponseEntity<List<MemberVO>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping("/res3")
	public ResponseEntity res3() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		String message = "<script>";
		message += "alert('새 회원을 등록합니다.');";
		message += "location.href='/test/memberList2';";
		message += "</script>";
		return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	}
}
