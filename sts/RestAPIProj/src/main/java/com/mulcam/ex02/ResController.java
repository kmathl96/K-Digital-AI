package com.mulcam.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// controller의 메소드들은 jsp를 리턴한 후 브라우저에 결과를 표시
public class ResController {
	@RequestMapping(value="/res1")
	@ResponseBody // @ResponseBody를 적용하면 jsp가 아닌 텍스트나 json 결과를 전송
	public Map<String, Object> res1() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", "hong");
		map.put("name", "홍길동");
		return map;
	}
	
	// @Controller 클래스 메소드에 @ReponseBody를 적용하면 @RestController와 같은 효과
	@RequestMapping("/res4")
	@ResponseBody
	public String res4() {
		return "home";
	}

	@RequestMapping("/res2")
	public String res2() {
		return "home";
	}
}
