package my.spring.springweb.sample08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingConsumesController {
	
	Logger log = LogManager.getLogger("case3");
	
	@RequestMapping(value="/testController1",
			method=RequestMethod.GET, //method 방식을 명시적으로 지정해줄 경우 value= 생략할 수 없음
			consumes = { "application/json","application/xml" })
	//MINE TYPE : consumes 속성에 적혀있는 저런 놈들을 지칭함 -> 웹 브라우저(서버)가 받을 데이터(코드)가 어떤 종류의 코드인지를 인식시킬 수 있는 역할
	//text/html --> 텍스트이면서 html이라는 의미(더욱 상세한 표현을 위해 이러한 계층구조를 사용하기 시작했다고 함)
	//application/json --> application은 '현재 데이터의 종류'라는 의미를 가짐 / json 타입이라는 의미
	
	//consumes 속성은 서버에서 클라이언트로 전송하는 코드의 MINE TYPE이 아니라 서버에서 받는 코드의 MINE TYPE을 정해주는 속성임
	//이런 MINE TYPE은 header에 담아서 주고 받음
	public String myMethod1() {
		
		log.debug("GET방식으로 호출되었습니다.");
		
		return null;
	}
	
	@RequestMapping(value="/testController2",
			method=RequestMethod.POST,
			consumes = { "application/json","application/x-www-form-urlencoded" })
	//application/x-www-form-urlencoded이 content-type의 default 설정임(기본적인 방식으로 인코딩한 형식이라는 의미)
	//이런 설정은 왜 해줌? REST API 설계할 때 많이 사용한다고 함 ex)ajax
	
	public String myMethod2() {
		
		log.debug("POST방식으로 호출되었습니다.");
		
		return null;
	}
	
}
