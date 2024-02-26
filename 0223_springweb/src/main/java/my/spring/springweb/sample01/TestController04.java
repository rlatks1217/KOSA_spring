package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//일반적으로 RequestMapping 어노테이션은 Class level에서 사용함
//즉, 메소드에 잘 붙이지는 않음
@RequestMapping(value="testController04")
public class TestController04 {
	
//	private static final Logger logger = LoggerFactory.getLogger(TestController04.class);

	//메소드에는 주로 이런 어노테이션이 붙음
	//메소드 호출 방식에 대한 어노테이션을 사용
	//get으로 요청이 들어올 경우 이 메소드가 호출
	@GetMapping
	String myMethod01() {
		
//		logger.debug("testController04호출!");
		return "sample/testController04";
	}
	
	@PostMapping(value="/test001")
	//여기에서도 처리를 담당할 url 할당할 수 있음
	String myMethod02() {
		
		return "sample/testController04";
	}
}
