package my.spring.springweb.sample03;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//이거 두 개 import 해야 함

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogTestController {
	
	Logger log = LogManager.getLogger("case3");
	//인자에다가 쓰려는 로그의 방식을 설정파일에서 정해줬던 logger의 이름으로 넣어주면 됨
	
	
	@RequestMapping(value="/log1")
	public String myMethod1() {
		
		log.debug("dkdkdkdk");
		
		return "sample03/logView";
	}
	
}
