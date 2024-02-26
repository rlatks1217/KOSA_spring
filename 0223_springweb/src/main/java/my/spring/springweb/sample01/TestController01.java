 package my.spring.springweb.sample01;

//import org.slf4j.Logger; //이걸로 import 해야 됨
//import org.slf4j.LoggerFactory; //이걸로 import 해야 됨
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController01 {
	
//	private static final Logger logger = LoggerFactory.getLogger(TestController01.class);
	//LoggerFactory에서 log를 실제로 찍는 객체를 하나 받아옴 인자에는 로그를 찍을 클래스를 명시해줌
	
	//기본은 http://localhost:8080/springweb임 즉, value에 써주는 문자열이 이 url 뒤에 붙게 되는 것 => 기본이니까 생략해도 된다는 의미
	//애초에 dispatcherServlet이 요청을 받았다는 거 자체가 http://localhost:8080/springweb까지는 접근을 했다는 얘기임 
	
	//슬레쉬(/)는 생략해도 알아서 붙여줌
	//method 호출 방식 생략할 경우 default인 get방식으로 method를 호출하게 됨
	//정해져있는 인터페이스같은 애(RequestMethod)의 상수값으로 메소드 호출방식이 상수로 다 저장되어 있음
	@RequestMapping(value="/testController01", method=RequestMethod.GET)
	String myMethod() { //지금은 해당 패키지 내에서만 이 메소드를 사용할 수 있으면 되기 때문에 접근제어자 default로 하자
		
		//handler에서 만약 return이 안 된다면 request url를 이용해서 결과 View Object를 생성하려고 해요
		//url에 나온 값을 이름으로 가진 파일을 찾음 그리고 그 파일을 이용하여 view를 만들어 클라이언트에 반환함(하지만 return을 잡는 것이 일반적이고 명확한 방식임)
//		logger.debug("/springweb/testController01 출력");
		
		return "sample/testController01";
		//해당 파일이 폴더 안에 있을 경우 위처럼 폴더 경로도 같이 적어서 return하면 됨
	}
}
