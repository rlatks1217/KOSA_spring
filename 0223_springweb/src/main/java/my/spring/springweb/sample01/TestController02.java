package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/testController01") //클래스 위에도 붙일 수 있음(url을 계층구조로 만들 수 있는 것임)
//그래서 아래 myMethod01라는 메소드를 호출하게 될 경우 /testController01/info 이런 식으로 url이 되는 것임
public class TestController02 {
	
//	private static final Logger logger = LoggerFactory.getLogger(TestController02.class);
	
	@RequestMapping("/info")
	//value= 라는 것도 생략이 가능(슬레쉬도 당연히 가능하지)
	String myMethod01() {
//		logger.debug("/testController01/info 호출!");
		return "sample/testController01";
	}
	
	@RequestMapping("/testController02/profile")
	String myMethod02() {
//		logger.debug("/testController02/profile 호출!");
		return "sample/testController02";
	}
	
	//이렇게 하나의 클래스로 여러 url를 받을 수 있음 (메소드 단위로 url을 받을 수 있으니까)
	@RequestMapping(value= {"","test01","test02","test03/*"})
	//여기에서도 value 생략이 가능함
	//뒤에 * 붙일 경우에는 url 끝에/ 붙여줘야 함
	String myMethod03() {
//		logger.debug("/testController01/멀티 호출!");
		return "sample/testController02";
	}
	

}
