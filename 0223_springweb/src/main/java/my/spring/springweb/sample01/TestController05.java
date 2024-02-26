package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/testController05")
public class TestController05 {

//	private static final Logger logger = LoggerFactory.getLogger(TestController05.class); 
	//이 클래스에 대한 정보를 주기 위해서 인자로 이 클래스명.class을 넣어줌 / 안 그러면 어디서 정확히 log가 실행되는 클래스를 출력해줄 수 없음(인자로 넣어주는 클래스를 출력하게 됨)
	
	@GetMapping(params="myName")
	//value로 url 따로 안 주면 위에 @RequestMapping에 써준 url까지만 쓰면 이 메소드가 호출됨
	//단, value는 없는데 params을 써줄 경우에는 넘어오는 데이터의 key값이 params에 적어준 문자열과 일치할 때만 호출됨
	// --> parameter로 들어오는 데이터에 따라 호출하는 메소드를 정할 수도 있단 얘기
	
	//그래서 넘어오는 데이터의 key값 중 params에 써있는 문자열과 일치하는 key값이 없을 경우 오류가 남!(400 - 잘못된 요청 오류)
	String myMethod01() {
		
//		logger.debug("testController05 호출!");
		
		return "sample/testController05";
	}
	
	@GetMapping(params="myName=신사임당") //이럴 경우에는 myName이라는 key값이 넘어오면서 그에 따른 value가'신사임당'일 때만 이 메소드가 호출됨
	String myMethod02() {
//		logger.debug("testController05 호출!");
		
		return "sample/testController05";
	}
	
	//url에 myName=신사임당 이라고 썼을 때는 사실 이 두 메소드가 조건에 다 충족됨(하지만 조금 더 부합하는 url을 스프링이 자체적으로 선택해서 호출하게 됨)
	//그래서 @GetMapping(params="myName=신사임당")라고 써있는 어노테이션이 붙은 메소드가 호출되는 것
}
