package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testController07")
public class TestController07 {

//	private static final Logger logger = LoggerFactory.getLogger(TestController07.class); 
	
	@GetMapping
	public String myMethod(Model model) {//Application Context에 의해서 model객체가 주입됨
		
//		logger.debug("TestController07 호출!");
		
		//Model에는 데이터가 key:value의 쌍으로 저장됨(Map처럼)
		model.addAttribute("myName", "ㅎㅇㅎㅇㅀㅇ"); //데이터 집어넣기
		model.addAttribute("myAge", 211111111); //데이터 집어넣기
		
		
		return "sample/testController07";
	}
}
