package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
@RequestMapping(value="/testController06")
public class TestController06 {

//	private static final Logger logger = LoggerFactory.getLogger(TestController06.class); 
	
	public TestController06() {
//		logger.debug("TestController06 Bean 생성!");
	}
	
	@GetMapping
	public ModelAndView showStaticView(Model model) {
		
//		logger.debug("testController06 호출!");
		
		//html인 경우 webapp 하단부터 절대경로를 이용하면 편해요! 절대 경로는 webapp폴더가 있는 경로를 의미함(즉, /만 쓰면 기본적으로 인식되는 경로가 절대 경로임)
		InternalResourceView view = new InternalResourceView("/resources/sample/testController06.html");
		//jsp나 정적 resource(데이터가 변하는 부분이 포함하지 않은 html이나 css같은 것)를 화면에 표현할 로직을 가지고 있는 객체 생성
		//당연히 어떤 파일의 내용을 가지고 View객체를 만들지 인자로 넣어줘야 함 
		ModelAndView modelAndview = new ModelAndView(view); //model객체가 필요없으면 안 넣어줘도 됨
		
		//결국 dispatcher Servlet이 view 객체를 만들고 rendering까지 해서 클라이언트에게 응답하게 됨
		//(여기에 rendering은 결국 html 코드로 만드는데 중간에 변수같은 데이터가 들어가는 부분들도 다 채워주는 등의 처리해주는 것을 말함)
		//rendering : 화면에 표시할 웹 페이지를 그리는 과정
		
		return modelAndview;
	}
}
