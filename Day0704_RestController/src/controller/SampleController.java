package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@ResponseBody
	@RequestMapping("/hello")
	public Map<String, Object> test() {
		System.out.println("sample/hello 요청 받았습니다.");
		Map<String,Object> testMap = new HashMap<String,Object>();
		testMap.put("test", "testmap 입니다!!");
		return testMap;
	}
	
	@RequestMapping("/board/{boardNum}")
	public String board(@PathVariable("boardNum")int num) {
		System.out.println(num);
		return "reply";
	}
}
